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
<html lang="UTF-8" class="js">

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
<title>Afpa - Nouvelle action</title>
<!-- StyleSheets  -->
<link rel="stylesheet" href="./assets/css/dashlite.css?ver=2.2.0">
<link id="skin-default" rel="stylesheet"
	href="./assets/css/theme.css?ver=2.2.0">
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

<%Action action = (Action)request.getAttribute("action"); %>
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
								<!-- .nk-block-head -->
								<div class="nk-block nk-block-lg">
									<div class="nk-block-head">
										<div class="nk-block-head-content">
											<h4 class="title nk-block-title">Modification</h4>
										</div>
									</div>
									<div class="card card-preview">
										<div class="card-inner">
											<div class="card">
												<div class="card-inner">
													<form method="POST" class="gy-3">
														<div class="row g-3 align-center">
															<div class="col-lg-5">
																<div class="form-group">
																	<label class="form-label" for="site-name">Type
																		d'action</label>
																</div>
															</div>
															<div class="col-lg-7">
																<div class="g-4 align-center flex-wrap">

																	<div class="g">
																		<div
																			class="custom-control custom-control-lg custom-radio">
																			<input type="radio" class="custom-control-input"
																				name="type" <%
																				if(action.getType()==1){%>checked<%}%> id="customRadio5" value="1">
																			<label class="custom-control-label"
																				for="customRadio5">Marketing</label>
																		</div>
																	</div>
																	<div class="g">
																		<div
																			class="custom-control custom-control-lg custom-radio">
																			<input type="radio" <%
																				if(action.getType()==2){%>checked<%}%> class="custom-control-input"
																				name="type" id="customRadio6" value="2"> <label
																				class="custom-control-label" for="customRadio6">Communication</label>
																		</div>
																	</div>
																</div>
																</div>
														</div>
														<div class="row g-3 align-center">
															<div class="col-lg-5">
																<div class="form-group">
																	<label class="form-label" for="site-name">Thême
																		de l'action</label>
																</div>
															</div>
															<div class="col-lg-7">
																<div class="form-group">
																	<div class="form-control-wrap">
																		<input required name="input_theme" type="text"
																			class="form-control" id="theme" value="${action.getTheme()}"
																			placeholder="Ma nouvelle action">
																	</div>
																</div>
															</div>
														</div>
														<div class="row g-3 align-center">
															<div class="col-lg-5">
																<div class="form-group">
																	<label class="form-label">Dispositif stratégique</label>
																</div>
															</div>
															<div class="col-lg-7">
																<div class="form-control-wrap">
																	<select required name="input_dispo"
																		class="form-select form-control form-control-lg"
																		data-search="on" id="ds">
																		<%
																		ArrayList<Dispositif_strategique> dispo = new ArrayList<Dispositif_strategique>();
																		dispo = (ArrayList<Dispositif_strategique>) request.getAttribute("dispo");
																		for (Dispositif_strategique d : dispo) {
																		%>
																		<option value="<%=d.getId()%>"><%=d.getTitre()%></option>
																		<%}%>

																	</select>
																	
																	<script>
										                                    document.getElementById('ds').value=${action.getId_dispo()};
										                                    </script>
										                                    
										                                    
																</div>
															</div>
														</div>
														<div class="row g-3 align-center">
															<div class="col-lg-5">
																<div class="form-group">
																	<label class="form-label">Plan de marché</label>
																</div>
															</div>
															<div class="col-lg-7">
																<div class="form-group">
																	<div class="form-control-wrap">
																		<select required name="input_pmarche"
																			class="form-select form-control form-control-lg"
																			data-search="on" id="pmarche">
																			<%
																			ArrayList<Plan_marche> pmarche = new ArrayList<Plan_marche>();
																			pmarche = (ArrayList<Plan_marche>) request.getAttribute("pmarche");
																			for (Plan_marche p : pmarche) {
																			%>
																			<option value="<%=p.getId()%>"><%=p.getTitre()%></option>
																			<%}%>
																		</select>
																		
																		<script>
										                                    document.getElementById('pmarche').value=${action.getId_plan()};
										                                    </script>
																	</div>
																</div>
															</div>
														</div>
														<div class="row g-3 align-center">
															<div class="col-lg-5">
																<div class="form-group">
																	<label class="form-label">Sous-secteur</label>
																</div>
															</div>
															<div class="col-lg-7">
																<div class="form-group">
																	<div class="form-control-wrap">
																		<select required name="input_ssecteur"
																			class="form-select form-control form-control-lg"
																			data-search="on"
																			id="ss">
																			<%
																			ArrayList<Sous_secteur> ssecteurs = new ArrayList<Sous_secteur>();
																			ssecteurs = (ArrayList<Sous_secteur>) request.getAttribute("ssecteur");
																			for (Sous_secteur ss : ssecteurs) {
																			%><option
																				value="<%=ss.getId()%>"><%=ss.getTitre()%></option>
																			<%}%>
																			
																			<script>
										                                    document.getElementById('ss').value=${action.getId_ssecteur()};
										                                    </script>
																			

																		</select>
																		
																	</div>
																</div>
															</div>
														</div>
														<div class="row g-3 align-center">
															<div class="col-lg-5">
																<div class="form-group">
																	<label class="form-label">Cibles</label>
																</div>
															</div>
															<div class="col-lg-7">
																<div class="form-group">
																	<div class="form-control-wrap">
																		<select required name="input_cible"
																			class="form-select form-control form-control-lg"
																			data-search="on"
																			id="cb">
																			<%
																			ArrayList<Cible> cibles = new ArrayList<Cible>();
																			cibles = (ArrayList<Cible>) request.getAttribute("cibles");
																			for (Cible c : cibles) {
																			%><option
																				value="<%=c.getId()%>"><%=c.getTitre()%></option>
																			<%}%>

																		</select>
																		<script>
										                                    document.getElementById('cb').value=${action.getId_cible()};
										                                    </script>
																	</div>
																</div>
															</div>
														</div>

														<div class="row g-3 align-center">
															<div class="col-lg-5">
																<div class="form-group">
																	<label class="form-label">Centre</label> <span
																		class="form-note">Plusieurs choix possible</span>
																</div>
															</div>
															<div class="col-lg-7">
																<div class="form-group">
																	<div class="form-control-wrap">
																		<select required name="centres" class="form-select"
																			multiple="multiple"
																			data-placeholder="Liste des centres">
																			<option value="0">Tous les centres</option>
																			<%
																			ArrayList<Integer>cs = (ArrayList<Integer>)request.getAttribute("cs");
																			ArrayList<Centre> centres = new ArrayList<Centre>();
																			centres = (ArrayList<Centre>) request.getAttribute("centres");
																			for (Centre c : centres) {
																			%>
																			<option value="<%=c.getId()%>"<%if(cs.contains(c.getId())){
																			%>selected<%}%>><%=c.getTitre()%></option>
																			<%}%>
																		</select>
																	</div>
																</div>
															</div>
														</div>
														<div class="row g-3 align-center">
															<div class="col-lg-5">
																<div class="form-group">
																	<label class="form-label">Canal</label> <span
																		class="form-note">Plusieurs choix possible</span>
																</div>
															</div>
															<div class="col-lg-7">
																<div class="form-group">
																	<div class="form-control-wrap">
																		<select required name="canal" class="form-select"
																			multiple="multiple"
																			data-placeholder="Liste des canaux"
																			id="canall">

																			<%
																			ArrayList<Canal> cused=(ArrayList<Canal>)request.getAttribute("cu");
																			ArrayList<Integer>listid = new ArrayList<Integer>();
																			for(Canal c : cused){
																				listid.add(c.getId());
																			}
																			System.out.println(listid);
																			ArrayList<Canal> ccom = new ArrayList<Canal>();
																			ccom = (ArrayList<Canal>) request.getAttribute("canal");
																			for (Canal cc : ccom) {
																			%>
																			<option value="<%=cc.getId()%>"<%if(listid.contains(cc.getId())){
																			%>selected<%}%> ><%=cc.getTitre()%></option>
																			<%
																			}
																			%>
																		</select>
																		
																		
																		
																		
																		
																	</div>
																</div>
															</div>
														</div>
														<div class="row g-3 align-center">
															<div class="col-lg-5">
																<div class="form-group">
																	<label class="form-label" for="site-off">Positionnement</label>
																</div>
															</div>
															<div class="col-lg-7">
																<ul
																	class="custom-control-group g-3 align-center flex-wrap">
																	<%
																	ArrayList<Positionnement> positionnement = new ArrayList<Positionnement>();
																	positionnement = (ArrayList<Positionnement>) request.getAttribute("pos");
																	for (Positionnement p : positionnement) {
																	%>
																	<li>
																		<div class="custom-control custom-radio">
																			<input type="radio" class="custom-control-input"
																				<%if (action.getId_positionnement()==p.getId()){%>checked<%}%> name="pos" value="<%=p.getId()%>"
																				id="<%=p.getId()%>"> <label
																				class="custom-control-label" for="<%=p.getId()%>"><%=p.getTitre()%></label>
																		</div>
																	</li>
																	<%}%>
																	</ul>
															</div>
														</div>
														<div class="row g-3 align-center">
															<div class="col-lg-5">
																<div class="form-group">
																	<label class="form-label">Semaine</label>
																</div>
															</div>
															<div class="col-lg-7">
																<div class="form-group">
																	<div class="form-control-wrap">
																		<input required name="date"
																			class="form-control date-picker datepicker "
																			id="weeklyDatePicker"
																			value="${ddate}"
																			>
																	</div>
																</div>
															</div>
														</div>

														<div class="row g-3">
															<div class="col-lg-7 offset-lg-5">
																<div class="form-group mt-2">
																	<button name="bsave" type="submit"
																		class="btn btn-lg btn-primary">Sauvegarder les changements</button>
																</div>
															</div>
														</div>
													</form>
												</div>
											</div>
											<!-- card -->
										</div>
									</div>
									<!-- .card-preview -->

								</div>

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
	<script src="./assets/js/parsley.js"></script>
	<script src="./assets/js/fr.js"></script>

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
			calendarWeeks: true,
			language : 'fr',
			autoclose : true,
			todayHighlight : true
		})
	</script>



</body>

</html>