<%@page import="models.Sous_secteur"%>
<%@page import="models.Plan_marche"%>
<%@page import="models.Dispositif_strategique"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>




<%ArrayList<Sous_secteur> ds = (ArrayList<Sous_secteur>)request.getAttribute("ss"); %>

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
											<h1 class="nk-block-title page-title">Sous secteur</h1>

										</div>
										<!-- .nk-block-head-content -->
									</div>
									<!-- .nk-block-between -->
								</div>
								<!-- .nk-block-head -->
								<div class="nk-block nk-block-lg">
									

									<!-- Debut tableau -->
									<div class="card card-preview">
										<div class="card-inner">
											<table id="table_id"
												class="datatable-init  nowrap nk-tb-list nk-tb-ulist datatable"
												data-auto-responsive="true">
												<thead>
													<tr class="nk-tb-item nk-tb-head">

														<th class="nk-tb-col"><span class="sub-text">Titre</span></th>
														<th class="nk-tb-col tb-col-mb"><span
															class="sub-text">Visibilité</span></th>
															<th class="nk-tb-col tb-col-lg"><span
															class="sub-text"></span></th>
													</tr>
												</thead>
												<tbody>
													<%for(Sous_secteur cc : ds){ 
														String etat = "";
													if(cc.getVisible()==0){
														etat="Sous secteur Invisible";
													}else{
														etat="Sous secteur Visible";
													}
													%>
													<tr class="nk-tb-item red">

														<td class="nk-tb-col">
															<div class="user-card">
																<div class="user-info">
																	<span class="tb-lead"><%=cc.getTitre()%><span
																		class="dot dot-success d-md-none ml-1"></span></span>
																</div>
															</div>
														</td>
														<td class="nk-tb-col tb-col-md"><span><%=etat %></span></td>
														
														<td class="nk-tb-col nk-tb-col-tools">
															<ul class="nk-tb-actions gx-1">

																<li>
																	<div class="drodown">
																		<a href="#"
																			class="dropdown-toggle btn btn-icon btn-trigger"
																			data-toggle="dropdown"><em
																			class="icon ni ni-more-h"></em></a>
																		<div class="dropdown-menu dropdown-menu-right">
																			<form>
																			<ul class="link-list-opt no-bdr">
																			<%if(cc.getVisible()==0){ %>
																				<li><button name="change<%=cc.getId()%>"
										class="btn "><em class="icon ni ni-plus"></em>Rendre visible</button></li>
																				<%}else{%>
																			<li><button name="change<%=cc.getId()%>"
										class="btn "><em class="icon ni ni-minus"></em>Rendre invisible</button></li>
																						<%}%>
																			</ul>
																			</form>
																		</div>
																	</div>
																</li>
															</ul>
														</td>
													</tr>
													<%}%>
													
													
													<!-- .nk-tb-item  -->
												
												
												</tbody>
											</table>
										</div>
									</div>
									<!-- .card-preview -->
								</div>
								<div class="row g-3">
							<div class="col-lg-7 offset-lg-5">
								<div class="form-group mt-2">
									<button name="newUser"
										class="btn btn-lg btn-primary " data-toggle="modal" data-target="#modalLarge"><em class="icon ni ni-plus"></em> Nouveau Sous-secteur</button>
								</div>
							</div>
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
	
	
	<div class="modal fade" tabindex="-1" id="modalLarge">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Nouveau sous_secteur</h5>
					<a href="#" class="close" data-dismiss="modal" aria-label="Close">
						<em class="icon ni ni-cross"></em>
					</a>
				</div>
				<div class="modal-body">
					<form method="POST" class="gy-3" data-parsley-validate="">
						<div class="row g-3 align-center">
							<div class="col-lg-5">
								<div class="form-group">
									<label class="form-label">Titre du sous secteur :</label>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="form-group">
									<div class="form-control-wrap">
									<input type="text" class="form-control" name="new">
																		
									</div>
								</div>
							</div>
						</div>
						<div class="row g-3">
							<div class="col-lg-7 offset-lg-5">
								<div class="form-group mt-2">
									<button name="newsave" class="btn btn-lg btn-primary">Valider</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- app-root @e -->
	<!-- JavaScript -->
	<script src="./assets/js/bundle.js?ver=2.2.0"></script>
	<script src="./assets/js/scripts.js?ver=2.2.0"></script>
	<script src="./assets/js/charts/chart-ecommerce.js?ver=2.2.0"></script>
	
</body>

</html>