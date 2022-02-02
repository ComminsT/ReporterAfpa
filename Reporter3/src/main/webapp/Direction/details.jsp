
<%@page import="models.TypeDAO"%>
<%@page import="models.Type"%>
<%@page import="models.Canal_com"%>
<%@page import="models.Canal_comDAO"%>
<%@page import="models.Canal_com_used"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="models.Utilisateur"%>
<%@page import="models.UtilisateurDAO"%>
<%@page import="models.Resultat_com"%>
<%@page import="models.Result_market"%>
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
<%@ page import="models.Result_market"%>
<%@ page import="models.Resultat_com"%>

<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="zxx" class="js">

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
<title>Afpa - Reporting complet</title>
<!-- StyleSheets  -->

</head>
<style>
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}
</style>
<link rel="stylesheet" href="./assets/css/dashlite.css?ver=2.2.0">
<link id="skin-default" rel="stylesheet"
	href="./assets/css/theme.css?ver=2.2.0">

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

				<%
				Action a = (Action) request.getAttribute("action");
				Result result = (Result) request.getAttribute("result");
				Database.Connect();
				UtilisateurDAO utilisateurdao = new UtilisateurDAO();
				Canal_usedDAO canaluseddao = new Canal_usedDAO();
				CanalDAO canaldao = new CanalDAO();
				Center_selectedDAO centerselecteddao = new Center_selectedDAO();
				CentreDAO centredao = new CentreDAO();
				Dispositif_strategiqueDAO dispositifstrategiquedao = new Dispositif_strategiqueDAO();
				Plan_marcheDAO planmarchedao = new Plan_marcheDAO();
				Sous_secteurDAO soussecteurdao = new Sous_secteurDAO();
				CibleDAO cibledao = new CibleDAO();
				PositionnementDAO positionnementdao = new PositionnementDAO();

				Centre centre = new Centre();
				Canal canal = new Canal();
				Center_selected center_selected = new Center_selected();
				Canal_used canalused = new Canal_used();

				Dispositif_strategique dispositifstrategique = dispositifstrategiquedao.getById(a.getId_dispo());
				Plan_marche planmarche = planmarchedao.getById(a.getId_plan());
				Sous_secteur soussecteur = soussecteurdao.getById(a.getId_ssecteur());
				Cible cible = cibledao.getById(a.getId_cible());
				Positionnement position = positionnementdao.getById(a.getId_positionnement());
				ArrayList<Canal_used> cused = canaluseddao.getAllByIdAction(a.getId());
				ArrayList<Center_selected> cselected = centerselecteddao.getAllByIdAction(a.getId());
				Utilisateur u = utilisateurdao.getById(result.getId_utilisateur());

				String status = "";
				String type = "";
				if (a.getType() == 1) {
					type = "marketing";
				} else {
					type = "communication";
				}
				String y = a.getSemaine() + "";
				String year = y.substring(0, 4);
				String semaine = y.substring(4);
				%>

				<div class="nk-content ">
					<div class="container-fluid">
						<div class="nk-content-inner">
							<div class="nk-content-body">
								<div class="nk-block-head nk-block-head-sm">
									<div class="nk-block-between">
										<div class="nk-block-head-content">
											<h1 class="nk-block-title page-title">Details de
												l'action</h1>
										</div>
										<!-- .nk-block-head-content -->
									</div>
									<!-- .nk-block-between -->
								</div>
								<!-- .nk-block-head -->
								<div class="nk-block nk-block-lg">


									<div class="nk-block nk-block-lg">
										<div class="row g-gs">
											<div class="col-md-4 col-lg-6">
												<div class="card card-preview">
													<div class="card-inner">
														<div class="text-center">
															<h4 class="nk-block-title">
																Action
																<%=type%></h4>

														</div>
													</div>
												</div>
												<!-- .card-preview -->
											</div>
											<div class="col-md-4 col-lg-6">
												<div class="card card-preview">
													<div class="card-inner">
														<div class="text-center">
															<h4 class="nk-block-title">
																Semaine
																<%=semaine%>
																-
																<%=year%></h4>

														</div>
													</div>
												</div>
												<!-- .card-preview -->
											</div>

										</div>

									</div>

									<%
									Result_market rmarket = (Result_market) request.getAttribute("rmarket");
									System.out.println("id de result_market : " + rmarket.getId());
									System.out.println("etat de rmarket : " + rmarket.getEtat());
									Resultat_com rcom = (Resultat_com) request.getAttribute("rcom");
									System.out.println("id de rcom : " + rcom.getId());
									%>
									<div class="nk-block nk-block-lg">
										<ul class="nav nav-tabs">

											<li class="nav-item"><a class="nav-link active"
												data-toggle="tab" href="#tabItem5"><em
													class="icon ni ni-happy"></em><span>Programmation</span></a></li>

											<%
											if (rmarket.getEtat() == 1) {
											%>
											<li class="nav-item"><a class="nav-link "
												data-toggle="tab" href="#tabItem6"><em
													class="icon ni ni-happy"></em><span>Marketing</span></a></li>
											<%}%>

											<%
											if (rcom.getEtat() == 1) {
											%>
											<li class="nav-item"><a class="nav-link"
												data-toggle="tab" href="#tabItem7"><em
													class="icon ni ni-instagram"></em><span>Communication</span></a>
											</li>
											<%}%>
											<%if(a.getStatus()==3&&a.getType()!=2){ %>
											<li class="nav-item"><a class="nav-link "
												data-toggle="tab" href="#tabItem8"><em
													class="icon ni ni-happy"></em><span>Plateforme
														telephonique</span></a></li>
												<%} %>
										</ul>
										<div class="tab-content">
										<div class="tab-pane active" id="tabItem5">
												<div class="card">
													<div class="card-inner">
														<form action="#" class="gy-3" data-parsley-validate="">
															<div class="row g-3 align-center">
																<div class="col-lg-5">
																	<div class="form-group">
																		<label class="form-label" for="site-name">Théme
																			de la campagne : </label>
																	</div>
																</div>
																<div class="col-lg-7">
																	<div class="form-group">
																		<div class="form-control-wrap">
																			<input value="<%=a.getTheme()%>" disabled=""
																				type="text" class="form-control" id="site-name"
																				name="visuel" data-parsley-trigger="change" disabled>

																		</div>
																	</div>
																</div>
															</div>
															<div class="row g-3 align-center">
																<div class="col-lg-5">
																	<div class="form-group">
																		<label class="form-label">Plan de marché :</label>
																	</div>
																</div>
																<div class="col-lg-7">
																	<div class="form-group">
																		<div class="form-control-wrap">
																			<input value="<%=planmarche%>" disabled=""
																				type="text" class="form-control" id="site-name"
																				name="visuel" required=""
																				data-parsley-trigger="change">
																		</div>
																	</div>
																</div>
															</div>
															<div class="row g-3 align-center">
																<div class="col-lg-5">
																	<div class="form-group">
																		<label class="form-label">Sous-secteur :</label>
																	</div>
																</div>
																<div class="col-lg-7">
																	<div class="form-group">
																		<div class="form-control-wrap">
																			<input value="<%=soussecteur%>" disabled type="week"
																				class="form-control date-picker datepicker "
																				id="weeklyDatePicker">
																		</div>
																	</div>
																</div>
															</div>
															<div class="row g-3 align-center">
																<div class="col-lg-5">
																	<div class="form-group">
																		<label class="form-label">Cible :</label>
																	</div>
																</div>
																<div class="col-lg-7">
																	<div class="form-control-wrap">

																		<input disabled value="<%=cible%>"
																			class="form-control " id="default-04">
																	</div>
																</div>
															</div>
															<div class="row g-3 align-center">
																<div class="col-lg-5">
																	<div class="form-group">
																		<label class="form-label">Canal :</label>
																	</div>
																</div>

																<div class="col-lg-7">
																	<div class="form-control-wrap">
																		<input type="text"
																			value="<%for (Canal_used cu : cused) {
	canal = canaldao.getById(cu.getId_canal());%><%=canal%>,<%}%>
                                                                         "
																			disabled class="form-control"
																			data-parsley-type="text" id="default-04">
																	</div>
																</div>
															</div>
															<div class="row g-3 align-center">
																<div class="col-lg-5">
																	<div class="form-group">
																		<label class="form-label">Centres :</label>
																	</div>
																</div>
																<div class="col-lg-7">
																	<div class="form-group">
																		<div class="form-control-wrap">
																			<div class="form-control-select-multiple">
																				<select disabled="" class="custom-select"
																					id="default-07" multiple>
																					<%
																					for (Center_selected cs : cselected) {
																						centre = centredao.getById(cs.getId_centre());
																					%>
																					<option value="option_select0"><%=centre%></option>
																					<%
																					}
																					%>
																				</select>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="row g-3 align-center">
																<div class="col-lg-5">
																	<div class="form-group">
																		<label class="form-label" for="site-name">Positionnement :</label>
																	</div>
																</div>
																<div class="col-lg-7">
																	<div class="form-control-wrap">
																		<input value="<%=position%>" disabled type="text"
																			class="form-control" id="default-04">
																	</div>
																</div>
															</div>

														</form>
													</div>
												</div>
											</div>
										
											
											
											<div class="tab-pane " id="tabItem6">
												<div class="nk-block nk-block-lg">
													<div class="nk-block-head"></div>
													<div class="card">
														<div class="card-inner">
															<form method="POST" class="gy-3" data-parsley-validate="">
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label" for="site-name">Visuel :</label>
																		</div>
																	</div>
																	<div class="col-lg-7">
																		<div class="form-group">
																			<div class="form-control-wrap">
																				<input type="text" class="form-control"
																					id="site-name" name="visuel"
																					placeholder="Insérez le lien du visuel"
																					value="${result.getVisuel()}" disabled>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label">Réalisation de la
																				campagne :</label>
																		</div>
																	</div>
																	<div class="col-lg-7">
																		<div class="form-group">
																			<div class="form-control-wrap">
																				<input
																					class="form-control  "
																					id="denvoi" name="denvoi" value="<%=u.getNom()+" "+u.getPrenom() %>" disabled>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label">Date d'envoi :</label>
																		</div>
																	</div>
																	<div class="col-lg-7">
																		<div class="form-group">
																			<div class="form-control-wrap">
																				<input placeholder="Sélectionnez la date d'envoi"
																					class="form-control date-picker datepicker show-week-number "
																					id="denvoi" name="denvoi" value="${date}" disabled>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label">Nombre de contact
																				ciblés :</label>
																		</div>
																	</div>
																	<div class="col-lg-7">
																		<div class="form-control-wrap">
																			<div class="form-icon form-icon-right">
																				<em
																					class="icon ni ni-send
                                                                            "></em>
																			</div>
																			<input type="number" class="form-control "
																				id="default-04"
																				placeholder="Entrez le nombre de contact ciblés"
																				name="nbrcontactcible"
																				value="${rmarket.getNbr_contactcible()}" disabled>
																		</div>
																	</div>
																</div>
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label">Nombre d'ouvreurs :</label>
																		</div>
																	</div>
																	<div class="col-lg-7">
																		<div class="form-control-wrap">
																			<div class="form-icon form-icon-right">
																				<em
																					class="icon ni ni-mail
                                                                            "></em>
																			</div>
																			<input type="number" class="form-control"
																				data-parsley-type="number" id="default-04"
																				placeholder="Entrez le nombre d'ouvreurs"
																				name="nbrouvreurs"
																				value="${rmarket.getNbr_ouvreurs()}" disabled>
																		</div>
																	</div>
																</div>
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label">Nombre de cliqueurs :
																			</label>
																		</div>
																	</div>
																	<div class="col-lg-7">
																		<div class="form-control-wrap">
																			<div class="form-icon form-icon-right">
																				<em class="icon ni ni-navigate"></em>
																			</div>
																			<input type="number" class="form-control"
																				id="default-04"
																				placeholder="Entrez le nombre de cliqueurs"
																				name="nbrcliqueurs"
																				value="${rmarket.getNbr_cliqueurs()}" disabled>
																		</div>
																	</div>
																</div>
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label" for="site-name">Nombre
																				de formulaires :</label>
																		</div>
																	</div>
																	<div class="col-lg-7">
																		<div class="form-control-wrap">
																			<div class="form-icon form-icon-right">
																				<em
																					class="icon ni ni-clipboad-check

                                                                            "></em>
																			</div>
																			<input type="number" class="form-control"
																				id="default-04"
																				placeholder="Entrez le nombre de formulaire remplis"
																				name="nbrformulaire"
																				value="${result.getNbr_formulaire()}" disabled>
																		</div>
																	</div>
																</div>

															</form>
														</div>
													</div>
													<!-- card -->
												</div>
												<!-- .nk-block -->
											</div>

											


											
											
											<div class="tab-pane" id="tabItem7">
												<div class="nk-block nk-block-lg">
													<div class="nk-block-head"></div>
													<div class="card">
														<div class="card-inner">
															<form method="POST" class="gy-3">
																<%
																ArrayList<Canal_com_used> ccused = (ArrayList<Canal_com_used>) request.getAttribute("ccomused");
																System.out.println("ArrayList length : "+ccused.size());
																				Canal_comDAO canal_comdao = new Canal_comDAO();
																Canal_com canal_com = new Canal_com();
																Type types = new Type();
																
																TypeDAO typedao = new TypeDAO();
																for (Canal_com_used cu : ccused) {
																	System.out.println("entrée boucle ccomused");	
																	int couverture = 0;
																	types = typedao.getById(cu.getId_type());
																	canal_com = canal_comdao.getById(cu.getId_canal_com());
																	if(cu.getTaux_couverture()!=0){
																		couverture=cu.getTaux_couverture();	
																	}
																	
																	
																%>
<%if(a.getType()==2){
	%>
	<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label" for="site-name">Visuel :</label>
																		</div>
																	</div>
																	<div class="col-lg-7">
																		<div class="form-group">
																			<div class="form-control-wrap">
																				<input type="text" class="form-control"
																					id="site-name" name="visuel"
																					placeholder="Insérez le lien du visuel"
																					value="${result.getVisuel()}" disabled>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label">Réalisation de la
																				campagne :</label>
																		</div>
																	</div>
																	<div class="col-lg-7">
																		<div class="form-group">
																			<div class="form-control-wrap">
																				<input
																					class="form-control  "
																					id="denvoi" name="denvoi" value="<%=u.getNom()+" "+u.getPrenom() %>" disabled>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label">Date d'envoi :</label>
																		</div>
																	</div>
																	<div class="col-lg-7">
																		<div class="form-group">
																			<div class="form-control-wrap">
																				<input placeholder="Sélectionnez la date d'envoi"
																					class="form-control date-picker datepicker show-week-number "
																					id="denvoi" name="denvoi" value="${date}" disabled>
																			</div>
																		</div>
																	</div>
																</div>
<%}%>
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label" for="site-name">Couverture
																				<%=canal_com.getTitre()%></label>
																		</div>
																	</div>
																	<div class="col-lg-5">
																		<div class="form-control-wrap">
																			<input type="number" class="form-control"
																				id="<%=cu.getId()%>" name="<%=cu.getId()%>"
																				placeholder="Entrez la couverture <%=canal.getTitre()%>"
																				value="<%=couverture%>"
																				name="<%=canal.getId()%>"
																				disabled>
																		</div>
																	</div>
																	<div class="col-lg-2">

																		<a data-toggle="modal"
																			data-target="#modal<%=cu.getId()%>"></a>
																	</div>

																</div>
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label" for="site-name">Type
																				d'action : </label>
																		</div>
																	</div>

																	<div class="col-lg-5">
																		<div class="form-group">
																			<div class="form-control-wrap">
																				<div class="form-group">
																					<label class="form-label"><%=types.getTitre()%>
																					</label>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>


																<%}%>
																<div class="row g-3 align-center">
																	<div class="col-lg-5">
																		<div class="form-group">
																			<label class="form-label" for="site-name">Nombre
																				de formulaire</label>
																		</div>
																	</div>
																	<div class="col-lg-7">
																		<div class="form-control-wrap">
																			<div class="form-icon form-icon-right">
																				<em
																					class="icon ni ni-clipboad-check

                                                                                "></em>
																			</div>
																			<input type="number" class="form-control"
																				id="default-04" name="formulairec"
																				placeholder="Entrez le nombre de formulaire remplis"
																				
																				value="${result.getNbr_formulaire()}"
																				disabled>
																		</div>
																	</div>
																</div>
															</form>
														</div>
													</div>
													<!-- card -->
												</div>
												<!-- .nk-block -->




											
										</div>
										<div class="tab-pane " id="tabItem8">
												<div class="nk-block nk-block-lg">
													<div class="nk-block-head"></div>
													<div class="card-inner">
													<%if(a.getStatus()==3){ %>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre de contact rappelés :</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-call
                                                                            "></em>
                                                                        </div>
                                                                        <input disabled name="nbrcontactrappele" type="number" value="${rappel}" class="form-control" id="nbrcontactrappele" >
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre de contact argumentés :</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-user-list
                                                                            "></em>
                                                                        </div>
                                                                        <input disabled name="nbrcontactargumente" type="number" class="form-control" value="${argumente}" placeholder="Entrez le nombre de contact argumentés">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre d'inscription en information collective :</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-info-i

                                                                            "></em>
                                                                        </div>
                                                                        <input disabled name="nbrinscriptionic" type="number" class="form-control" value="${ic}" placeholder="Entrez le nombre d'inscription en information collective">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            
                                                            <%
                                                            if(a.getId_positionnement()==1){ %>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre d'envoi de catalogue :</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-book-read


                                                                            "></em>
                                                                        </div>
                                                                        <input disabled name="nbrenvoicatalogue" type="number" class="form-control" value="${catalogue}" placeholder="Entrez le nombre d'envoi de catalogue">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre d'inscription en événement :</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-ticket
                                                                            "></em>
                                                                        </div>
                                                                        <input disabled name="nbrinscriptionevent" type="number" class="form-control" value="${event}" placeholder="Entrez le nombre d'inscription en événement">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre de prise de RDV :</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-calendar-booking

                                                                            "></em>
                                                                        </div>
                                                                        <input disabled name="nbrrdv" type="number" class="form-control" value="${rdv}" placeholder="Entrez le nombre de prise de RDV">
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre de devis :</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-sign-euro
                                                                            "></em>
                                                                        </div>
                                                                        <input disabled name="nbrdevis" type="number" class="form-control" value="${devis}" placeholder="Entrez le nombre de devis">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre de convention :</label>
                                                                    </div>
                                                                </div>
                                                                
                                                                
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-report-profit


                                                                            "></em>
                                                                        </div>
                                                                        <input disabled name="nbrconvention" type="number" class="form-control" value="${convention }" placeholder="Entrez le nombre de convention">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Commentaire :</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                            <div class="form-group">
                                                                                
                                                                                <div class="form-control-wrap">
                                                                                    <textarea disabled name="commentaire" class="form-control form-control-simple no-resize border" placeholder="Entrez votre commentaire ici" id="default-textarea">
                                                                                    <%ArrayList<String>commentaires = (ArrayList<String>)request.getAttribute("commentaires"); 
                                                                                    for(int i=1;i<commentaires.size()+1;i++){
                                                                                    %>
                                                                                    Commentaire <%=i%> : <%=commentaires.get(i-1)%>&#10;
                                                                                    
                                                                                    <%} %>
                                                                                    
                                                                                    
                                                                                    
                                                                                    </textarea>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    
                                                                </div>
                                                            </div>
                                                            <%}%>
                                                             
                                                    </div>
                                                    <%}%>
													<!-- card -->
												</div>
												<!-- .nk-block -->
											</div>
											
										</div>
										<!-- card -->

									</div>
									<!-- .nk-block -->

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
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script src="./assets/js/parsley.js"></script>
	<script src="./assets/js/fr.js"></script>
	<script src="./assets/js/bundle.js?ver=2.2.0"></script>
	<script src="./assets/js/scripts.js?ver=2.2.0"></script>
	<script src="./assets/js/charts/chart-ecommerce.js?ver=2.2.0"></script>
	<script src="./assets/js/charts/chart-analytics.js?ver=2.2.0"></script>
	<script src="./assets/js/libs/jqvmap.js?ver=2.2.0"></script>
	<script src="./assets/js/example-chart.js?ver=2.2.0"></script>

	<script>
		;
		(function($) {
			$.fn.datepicker.dates['fr'] = {
				days : [ "dimanche", "lundi", "mardi", "mercredi", "jeudi",
						"vendredi", "samedi" ],
				daysShort : [ "dim.", "lun.", "mar.", "mer.", "jeu.", "ven.",
						"sam." ],
				daysMin : [ "d", "l", "ma", "me", "j", "v", "s" ],
				months : [ "janvier", "février", "mars", "avril", "mai",
						"juin", "juillet", "août", "septembre", "octobre",
						"novembre", "décembre" ],
				monthsShort : [ "janv.", "févr.", "mars", "avril", "mai",
						"juin", "juil.", "août", "sept.", "oct.", "nov.",
						"déc." ],
				today : "Aujourd'hui",
				monthsTitle : "Mois",
				clear : "Effacer",
				weekStart : 1,
				format : "dd/mm/yyyy"
			};
		}(jQuery));
		$('.datepicker').datepicker({
			language : 'fr',
			autoclose : true,
			todayHighlight : true
		})
	</script>


	<script>
		$(".dial").knob({
			'format' : function(value) {
				return value + '%';
			}
		});
	</script>
</body>

</html>