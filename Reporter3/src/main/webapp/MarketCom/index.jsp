<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="models.Action"%>
<%@ page import="models.Dispositif_strategiqueDAO"%>
<%@ page import="models.Dispositif_strategique"%>
<%@ page import="models.Plan_marche"%>
<%@ page import="models.Plan_marcheDAO"%>
<%@ page import="models.Sous_secteur"%>
<%@ page import="models.Sous_secteurDAO"%>
<%@ page import="models.Cible"%>
<%@ page import="models.CibleDAO"%>
<%@ page import="models.Canal_used"%>
<%@ page import="models.Canal_usedDAO"%>
<%@ page import="models.Canal"%>
<%@ page import="models.CanalDAO"%>
<%@ page import="models.Center_selected"%>
<%@ page import="models.Center_selectedDAO"%>
<%@ page import="models.Centre"%>
<%@ page import="models.CentreDAO"%>
<%@ page import="models.Result"%>
<%@ page import="models.Positionnement"%>
<%@ page import="models.PositionnementDAO"%>
<%@ page import="models.Database"%>

<%@ page import="java.util.ArrayList"%>






<!DOCTYPE html>
<html lang="fr" class="js">

<head>
<base href="../">
<meta charset="utf-8">
<meta name="author" content="Softnio">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="A powerful and conceptual apps base dashboard template that especially build for developers and programmers.">
<!-- Fav Icon  -->
<link rel="shortcut icon" href="./images/favicon.png">
<!-- Page Title  -->
<title>Afpa - Reporter</title>
<!-- StyleSheets  -->
<link rel="stylesheet" href="./assets/css/dashlite.css?ver=2.2.0">
<link id="skin-default" rel="stylesheet"
	href="./assets/css/theme.css?ver=2.2.0">
</head>

<body class="nk-body bg-lighter npc-default has-sidebar ">
	<div class="nk-app-root">
		<!-- main @s -->
		<div class="nk-main ">
			<!-- sidebar @s -->
			<jsp:include page="Sidebar" />
			<!-- sidebar @e -->
			<!-- wrap @s -->
			<div class="nk-wrap ">
				<!-- main header @s -->
				<jsp:include page="Header" />
				<!-- main header @e -->
				<!-- content @s -->
				<div class="nk-content ">
					<div class="container-fluid">
						<div class="nk-content-inner">
							<div class="nk-content-body">
								<div class="nk-block-head nk-block-head-sm">
									<div class="nk-block-between">
										<div class="nk-block-head-content">
											<h1 class="nk-block-title page-title">Accueil</h1>

										</div>
										<!-- .nk-block-head-content -->
									</div>
									<!-- .nk-block-between -->
								</div>
								<!-- .nk-block-head -->
								<div class="nk-block nk-block-lg">
									<div class="nk-block-head">
										<div class="nk-block-head-content">
											<h4 class="nk-block-title">Actions programmées pour la
												semaine ${weeknumber}</h4>
										</div>
									</div>

									<%
									int weeknumber = (int) request.getAttribute("weeknumber");
									int nextweek = weeknumber + 1;
									int previousweek = weeknumber - 1;
									int nextyear = (int) request.getAttribute("year");
									int previousyear = nextyear;

									if (weeknumber + 1 > 52) {
										nextweek = 1;
										nextyear += 1;
									} else if (weeknumber - 1 < 1) {
										previousyear -= 1;
										previousweek = 52;
									}
									%>
									<a
										href="marketcom/Index?semaine=<%=previousweek%>&year=<%=previousyear%>"><btn
											class="btn btn-primary"> <em
											class="icon ni ni-chevron-left"></em> <span>Semaine
											précédente</span></btn></a> <a
										href="marketcom/Index?semaine=<%=nextweek%>&year=<%=nextyear%>">
										<btn class="btn btn-primary"> </em> <span>Semaine
											suivante</span> <em class="icon ni ni-chevron-right"></em> </btn>
									</a>
									<!-- Debut tableau -->
									<div class="card card-preview">
										<div class="card-inner">
											<table id="table_id"
												class="datatable-init  nowrap nk-tb-list nk-tb-ulist datatable"
												data-auto-responsive="true">
												<thead>
													<tr class="nk-tb-item nk-tb-head">

														<th class="nk-tb-col"><span class="sub-text">Thème</span></th>
														<th class="nk-tb-col tb-col-mb"><span
															class="sub-text">Dispositif stratégique</span></th>
														<th class="nk-tb-col tb-col-md"><span
															class="sub-text">Plan de marché</span></th>
														<th class="nk-tb-col tb-col-lg"><span
															class="sub-text">Sous-secteur</span></th>
														<th class="nk-tb-col tb-col-lg"><span
															class="sub-text">Centre(s) concerné(s)</span></th>
														<th class="nk-tb-col tb-col-md"><span
															class="sub-text">Positionnement</span></th>
														<th class="nk-tb-col tb-col-md"><span
															class="sub-text">Canal</span></th>
														<th class="nk-tb-col tb-col-md"><span
															class="sub-text">Statut</span></th>
														<th class="nk-tb-col nk-tb-col-tools text-right"></th>
													</tr>
												</thead>
												<tbody>
													<%
													Database.Connect();
													Centre centre = new Centre();
													Canal canal = new Canal();
													Center_selected center_selected = new Center_selected();
													Canal_used canalused = new Canal_used();
													Dispositif_strategique dispositifstrategique = new Dispositif_strategique();
													Plan_marche planmarche = new Plan_marche();
													Sous_secteur soussecteur = new Sous_secteur();
													Cible cible = new Cible();
													Positionnement position = new Positionnement();

													Canal_usedDAO canaluseddao = new Canal_usedDAO();
													CanalDAO canaldao = new CanalDAO();
													Center_selectedDAO centerselecteddao = new Center_selectedDAO();
													CentreDAO centredao = new CentreDAO();
													Dispositif_strategiqueDAO dispositifstrategiquedao = new Dispositif_strategiqueDAO();
													Plan_marcheDAO planmarchedao = new Plan_marcheDAO();
													Sous_secteurDAO soussecteurdao = new Sous_secteurDAO();
													CibleDAO cibledao = new CibleDAO();
													PositionnementDAO positionnementdao = new PositionnementDAO();

													String status = "";

													ArrayList<Action> actions = (ArrayList<Action>) request.getAttribute("actions");

													for (Action a : actions) {
														String dispositif = dispositifstrategiquedao.getById(a.getId_dispo()) + "";
														String plandemarche = planmarchedao.getById(a.getId_plan()) + "";
														String ssecteur = soussecteurdao.getById(a.getId_ssecteur()) + "";

														ArrayList<Center_selected> c_s = centerselecteddao.getAllByIdAction(a.getId());
														ArrayList<Centre> centres = new ArrayList<Centre>();
														for (Center_selected cs : c_s) {
															centres.add(centredao.getById(cs.getId_centre()));

														}
														ArrayList<Canal_used> c_u = canaluseddao.getAllByIdAction(a.getId());
														ArrayList<Canal> canals = new ArrayList<Canal>();
														for (Canal_used cu : c_u) {
															canals.add(canaldao.getById(cu.getId_canal()));
														}
														if (a.getStatus() == 0) {
															status = "En préparation";
														} else if (a.getStatus() == 1) {
															status = "Envoyé";
														} else if (a.getStatus() == 2) {
															status = "En attente de rappel";
														} else if (a.getStatus() == 3) {
															status = "Terminé";
														}
														String positionnement = positionnementdao.getById(a.getId_positionnement()) + "";
													%>
													<tr class="nk-tb-item">

														<td class="nk-tb-col">
															<div class="user-card">
																<div class="user-info">
																	<span class="tb-lead"><%=a.getTheme()%><span
																		class="dot dot-success d-md-none ml-1"></span></span>
																</div>
															</div>
														</td>
														<td class="nk-tb-col tb-col-mb"><span><%=dispositif%>
														</span></td>
														<td class="nk-tb-col tb-col-md"><span><%=plandemarche%>
														</span></td>
														<td class="nk-tb-col tb-col-lg"><span><%=ssecteur%></span>
														</td>


														<td class="nk-tb-col">
															<div>
																<%
																for (Centre c : centres) {
																%>
																<span class="tb-lead"><%=c%></span>
																<%
																}
																%>
															</div>
														</td>
														<td class="nk-tb-col tb-col-md"><span
															class="tb-status text-warning"><%=positionnement%></span></td>
														<td class="nk-tb-col">
															<div>
																<%
																for (Canal c : canals) {
																%>
																<span class="tb-lead"><%=c%></span>
																<%}%>
															</div>

														</td>
														<td class="nk-tb-col tb-col-md"><span
															class="tb-status text-primary"><%=status%></span></td>
														<td class="nk-tb-col nk-tb-col-tools">
															<ul class="nk-tb-actions gx-1">

																<li>
																	<div class="drodown">
																		<a href="#"
																			class="dropdown-toggle btn btn-icon btn-trigger"
																			data-toggle="dropdown"><em
																			class="icon ni ni-more-h"></em></a>
																		<div class="dropdown-menu dropdown-menu-right">
																			<ul class="link-list-opt no-bdr">
																				<li><a
																					href="MarketCom/Details?action=<%=a.getId()%>"><em
																						class="icon ni ni-eye"></em><span>Détails</span></a></li>
																				<li><a
																					href="MarketCom/Modification?id=<%=a.getId()%>"><em
																						class="icon ni ni-edit"></em><span>Modification</span></a></li>
																				<%
																				if (a.getType() == 1) {
																				%>
																				<li><a
																					href="MarketCom/Reportingmc?id=<%=a.getId()%>"><em
																						class="icon ni ni-activity-round"></em><span>Reporting</span></a></li>
																				<%
																				} else {
																				%>

																				<li><a
																					href="MarketCom/Reportingc?id=<%=a.getId()%>"><em
																						class="icon ni ni-activity-round"></em><span>Reporting</span></a></li>
																				<%
																				}
																				%>

																			</ul>
																		</div>
																	</div>
																</li>
															</ul>
														</td>
													</tr>
													<!-- .nk-tb-item  -->

													<%}%>
												</tbody>
											</table>
										</div>
									</div>
									<!-- .card-preview -->
								</div>
								<!-- nk-block -->

							</div>
						</div>
					</div>
				</div>
				<!-- content @e -->
				<!-- footer @s -->

				<!-- footer @e -->
			</div>
			<!-- wrap @e -->
		</div>
		<!-- main @e -->
	</div>
	<!-- app-root @e -->
	<!-- JavaScript -->
	<script src="./assets/js/bundle.js?ver=2.2.0"></script>
	<script src="./assets/js/scripts.js?ver=2.2.0"></script>
	<script src="./assets/js/charts/chart-ecommerce.js?ver=2.2.0"></script>
</body>

</html>