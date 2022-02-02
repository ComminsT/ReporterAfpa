<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="models.Action"%>
<%@ page import="models.Canal_com"%>
<%@ page import="models.Utilisateur"%>
<%@ page import="models.Utilisateur"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="models.Canal_com_usedDAO"%>
<%@ page import="models.Canal_com_used"%>
<%@ page import="models.Canal_comDAO"%>
<%@ page import="models.Type"%>
<%@ page import="models.TypeDAO"%>

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
<title>Afpa - Reporting communication</title>
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
				<div class="nk-content ">
					<div class="container-fluid">
						<div class="nk-content-inner">
							<div class="nk-content-body">
								<div class="nk-block-head nk-block-head-sm">
									<div class="nk-block-between">
										<div class="nk-block-head-content">
											<h1 class="nk-block-title page-title">Reporting action
												communication</h1>
										</div>
										<!-- .nk-block-head-content -->
									</div>
									<!-- .nk-block-between -->
								</div>
								<!-- .nk-block-head -->
								<div class="nk-block nk-block-lg">
									<div class="nk-block-head">
										<div class="nk-block-head-content">
											<h4 class="nk-block-title">${action.getTheme()}</h4>
										</div>
									</div>
									<div class="nk-block nk-block-lg">
										<div class="card">
											<div class="card-inner">
												<form method="POST" class="gy-3">
													<div class="row g-3 align-center">
														<div class="col-lg-5">
															<div class="form-group">
																<label class="form-label" for="site-name">Visuel</label>
															</div>
														</div>
														<div class="col-lg-7">
															<div class="form-group">
																<div class="form-control-wrap">
																	<input required type="text" value="${result.getVisuel() }"
																		class="form-control" id="site-name" name="visuel"
																		data-parsley-trigger="change">
																</div>
															</div>
														</div>
													</div>
													<div class="row g-3 align-center">
														<div class="col-lg-5">
															<div class="form-group">
																<label class="form-label">Réalisation de la
																	campagne</label>
															</div>
														</div>
														<div class="col-lg-7">
															<div class="form-group">
																<div class="form-control-wrap">
																	<select name="user" id="user" class="form-select">
																		<option required value="0">Equipe marketing et
																			communication</option>
																		<%
																		ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>) request.getAttribute("users");
																		for (Utilisateur u : utilisateurs) {
																		%>
																		<option value="<%=u.getId()%>"><%=u.getNom() + " " + u.getPrenom()%></option>
																		<%}%>
																	</select>
																	<script>
																		document
																				.getElementById('user').value = $
																		{
																			result
																					.getId_utilisateur()
																		};
																	</script>
																</div>
															</div>
														</div>
													</div>
													<div class="row g-3 align-center">
														<div class="col-lg-5">
															<div class="form-group">
																<label class="form-label">Date de publication</label>
															</div>
														</div>
														<div class="col-lg-7">
															<div class="form-group">
																<div class="form-control-wrap">
																	<input required class="form-control date-picker datepicker "
																		id="weeklyDatePicker" name="date" value="${date}">
																</div>
															</div>
														</div>
													</div>

													<%
													ArrayList<Canal_com_used> cused = (ArrayList<Canal_com_used>) request.getAttribute("ccomused");
													Canal_comDAO canaldao = new Canal_comDAO();
													Canal_com canal = new Canal_com();
													Type type = new Type();
													TypeDAO typedao = new TypeDAO();
													for (Canal_com_used cu : cused) {
														int couverture = 0;
														type = typedao.getById(cu.getId_type());
														canal = canaldao.getById(cu.getId_canal_com());
														if (cu.getTaux_couverture() != 0) {
															couverture = cu.getTaux_couverture();
														}
													%>


													<div class="row g-3 align-center">
														<div class="col-lg-5">
															<div class="form-group">
																<label class="form-label" for="site-name">Couverture
																	<%=canal.getTitre()%></label>
															</div>
														</div>
														<div class="col-lg-5">
															<div class="form-control-wrap">
																<input required type="number" class="form-control"
																	id="<%=cu.getId()%>" name="<%=cu.getId()%>"
																	placeholder="Entrez la couverture <%=canal.getTitre()%>"
																	value="<%=couverture%>" name="<%=canal.getId()%>">
															</div>
														</div>
														<div class="col-lg-2">

															<a data-toggle="modal"
																data-target="#modal<%=cu.getId()%>"><em
																class="icon ni ni-minus-circle"></em></a>
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
																		<label class="form-label"><%=type.getTitre()%>
																		</label>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<%}%>
													<div align="center">

														<button align="center" type="button"
															class="btn btn-lg btn-primary" data-toggle="modal"
															data-target="#modalLarge">Nouvelle action</button>
														<button name="confirm" align="center"
															class="btn btn-lg btn-primary">Sauvegarder</button>
															<button name="validate" align="center"
															class="btn btn-lg btn-primary">Valider</button>
													</div>
												</form>
											</div>
										</div>
										<!-- card -->
									</div>
									<!-- .nk-block -->



									<!-- Debut tableau -->

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





	<div class="modal fade" tabindex="-1" id="modalLarge">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Nouvelle action</h5>
					<a href="#" class="close" data-dismiss="modal" aria-label="Close">
						<em class="icon ni ni-cross"></em>
					</a>
				</div>
				<div class="modal-body">
					<form method="POST" class="gy-3" data-parsley-validate="">
						<div class="row g-3 align-center">
							<div class="col-lg-5">
								<div class="form-group">
									<label class="form-label">Canal de communication</label>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="form-group">
									<div class="form-control-wrap">
										<select name="canalsave" class="form-select">
											<%
											ArrayList<Canal_com> ccoms = (ArrayList<Canal_com>) request.getAttribute("canalcoms");
											for (Canal_com cc : ccoms) {
											%>
											<option value="<%=cc.getId()%>"><%=cc.getTitre()%></option>
											<%}%>

										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row g-3 align-center">
							<div class="col-lg-5">
								<div class="form-group">
									<label class="form-label">Type d'action</label>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="form-group">
									<div class="form-control-wrap">
										<select name="typesave" class="form-select">
											<%
											ArrayList<Type> types = (ArrayList<Type>) request.getAttribute("types");
											for (Type t : types) {
											%>
											<option value="<%=t.getId()%>"><%=t.getTitre()%></option>
											<%}%>

										</select>
									</div>
								</div>
							</div>

						</div>
						<div class="row g-3">
							<div class="col-lg-7 offset-lg-5">
								<div class="form-group mt-2">
									<button name="savenewc" class="btn btn-lg btn-primary">Valider</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%
	for (Canal_com_used cu : cused) {
		type = typedao.getById(cu.getId_type());
		canal = canaldao.getById(cu.getId_canal_com());
	%>
	<div class="modal fade" tabindex="-1" id="modal<%=cu.getId()%>">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Suppression</h5>
					<a href="#" class="close" data-dismiss="modal" aria-label="Close">
						<em class="icon ni ni-cross"></em>
					</a>
				</div>
				<div class="modal-body">

					<form method="POST" class="gy-3" data-parsley-validate="">
						<div class="row g-3 align-center">
							<div class="col-lg-5">
								<div class="form-group">
									<label class="form-label">Canal de communication : <%=canal.getTitre()%></label>
								</div>
							</div>

						</div>
						<div class="row g-3 align-center">
							<div class="col-lg-5">
								<div class="form-group">
									<label class="form-label">Type d'action : <%=type.getTitre()%></label>
								</div>
							</div>

						</div>

						<div class="col-lg-12">
							<div class="form-group" align="center">
								<p class="form-label">Êtes-vous sur de vouloir supprimer
									cette action ?</p>
							</div>
						</div>
						<div class="row g-3">
							<div class="col-lg-7 offset-lg-5">
								<div class="form-group mt-2">
									<button name="deleteactionc<%=cu.getId()%>"
										class="btn btn-lg btn-primary">Valider</button>
								</div>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
	<%
	}
	%>
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
			calendarWeeks : true,
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