<%@page import="models.Groupe"%>
<%@page import="models.Dispositif_strategique"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>




<%ArrayList<Groupe> groupes = (ArrayList<Groupe>)request.getAttribute("groupes"); %>

<!DOCTYPE html>
<html lang="fr" class="js">

<head>
<base href="../">
 <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
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
											<h1 class="nk-block-title page-title">Groupes d'utilisateur</h1>

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
														
															
													</tr>
												</thead>
												<tbody>
													<%for(Groupe cc : groupes){ 
														
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
										class="btn btn-lg btn-primary " data-toggle="modal" data-target="#modalLarge"><em class="icon ni ni-plus"></em> Nouveau Groupe</button>
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
					<h5 class="modal-title">Nouveau groupe</h5>
					<a href="#" class="close" data-dismiss="modal" aria-label="Close">
						<em class="icon ni ni-cross"></em>
					</a>
				</div>
				<div class="modal-body">
					<form method="POST" class="gy-3" data-parsley-validate="">
						<div class="row g-3 align-center">
							<div class="col-lg-5">
								<div class="form-group">
									<label class="form-label">Titre du groupe :</label>
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