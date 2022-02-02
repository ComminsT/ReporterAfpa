<%@page import="models.GroupeDAO"%>
<%@page import="models.Database"%>
<%@page import="models.Group_listDAO"%>
<%@page import="models.Group_list"%>
<%@page import="models.Groupe"%>
<%@page import="models.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>




<%ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>)request.getAttribute("utilisateurs"); %>
<%ArrayList<Groupe>groupes = (ArrayList<Groupe>)request.getAttribute("groupes");
Group_listDAO glistdao = new Group_listDAO();%>

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
									

									<!-- Debut tableau -->
									<div class="card card-preview">
										<div class="card-inner">
											<table id="table_id"
												class="datatable-init  nowrap nk-tb-list nk-tb-ulist datatable"
												data-auto-responsive="true">
												<thead>
													<tr class="nk-tb-item nk-tb-head">

														<th class="nk-tb-col"><span class="sub-text">Nom</span></th>
														<th class="nk-tb-col tb-col-mb"><span
															class="sub-text">Prenom</span></th>
														<th class="nk-tb-col tb-col-md"><span
															class="sub-text">Mail</span></th>
														<th class="nk-tb-col tb-col-lg"><span
															class="sub-text">Groupe</span></th>
														<th class="nk-tb-col tb-col-lg"><span
															class="sub-text">Etat</span></th>
															<th class="nk-tb-col tb-col-lg"><span
															class="sub-text"></span></th>
													</tr>
												</thead>
												<tbody>
												
													<%
													Database.Connect();
													GroupeDAO groupedao = new GroupeDAO();
													Groupe groupe = new Groupe();
													for(Utilisateur u : utilisateurs){
														ArrayList<Group_list> currentglist=glistdao.getAllFromUtilisateurId(u.getId());
														String etat = "";
													if(u.getActive()==0){
														etat="Compte Inactif";
													}else{
														etat="Compte Actif";
													}
													%>
													<tr class="nk-tb-item red">

														<td class="nk-tb-col">
															<div class="user-card">
																<div class="user-info">
																	<span class="tb-lead"><%=u.getNom()%><span
																		class="dot dot-success d-md-none ml-1"></span></span>
																</div>
															</div>
														</td>
														<td class="nk-tb-col tb-col-mb "><span><%=u.getPrenom() %> </span></td>
														<td class="nk-tb-col tb-col-md"><span><%=u.getMail() %></span></td>
														<%if(currentglist.size()==0){%>
														<td class="nk-tb-col tb-col-md">
														<span>Pas de groupe</span>
														</td>
														<%}else{
															for(Group_list gl : currentglist){
																int glist=gl.getId_groupe();
																groupe=groupedao.getById(glist);
																%>
														
														<td class="nk-tb-col tb-col-md">
														<span><%=groupe.toString() %></span>
														
														<%}}%>
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
																		<ul class="link-list-opt no-bdr">
																		<form>
																			
																				<%if(u.getActive()==0){ %>
																				<li><button name="change<%=u.getId()%>"class="btn "><em class="icon ni ni-plus"></em>Activer</button></li>
																				<%}else{%>
																			<li><button name="change<%=u.getId()%>"class="btn "><em class="icon ni ni-plus"></em>Désactiver</button></li>
																						<%}%>
																			
																			
																			
																			
																			</form>
																			<li><button 
															class="btn " data-toggle="modal" data-target="#modal<%=u.getId()%>"><em class="icon ni ni-minus"></em>Gestion du groupe</button></li>
																			
																			</ul>
																				
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
									<a href="Admin/NouvelUtilisateur"><button name="newUser"
										class="btn btn-lg btn-primary "><em class="icon ni ni-plus"></em>Nouvel utilisateur</button></a>
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
	
	<%for(Utilisateur u : utilisateurs){ 
	ArrayList<Group_list>glist = glistdao.getAllFromUtilisateurId(u.getId());
	int id_grp =0;
	if(glist.size()!=0){
		
	id_grp=glist.get(0).getId_groupe();
	}
	
	%>
	
	<div class="modal fade" tabindex="-1" id="modal<%=u.getId()%>">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Gestion du groupe pour l'utilisateur :<%=u.getPrenom()+" "+u.getNom() %> </h5>
					<a href="#" class="close" data-dismiss="modal" aria-label="Close">
						<em class="icon ni ni-cross"></em>
					</a>
				</div>
				<div class="modal-body">
					<form method="POST" class="gy-3" data-parsley-validate="">
						<div class="row g-3 align-center">
							<div class="col-lg-5">
								<div class="form-group">
									<label class="form-label">Groupe :</label>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="form-group">
									<div class="form-control-wrap">
										<select id="idgrp<%=u.getId() %>" name="idgrp<%=u.getId()%>" class="form-select">
											<%
											for (Groupe g : groupes) {
											%>
											<option value="<%=g.getId()%>"><%=g.getTitre()%></option>
											<%}%>

										</select>
										
										<script>
										document.getElementById('idgrp<%=u.getId()%>').value=<%=id_grp%>
										</script>
										
									</div>
								</div>
							</div>
						</div>
						<div class="row g-3">
							<div class="col-lg-7 offset-lg-5">
								<div class="form-group mt-2">
									<button name="grpchange<%=u.getId()%>" class="btn btn-lg btn-primary">Valider</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%}%>
	
	<!-- app-root @e -->
	<!-- JavaScript -->
	<script src="./assets/js/bundle.js?ver=2.2.0"></script>
	<script src="./assets/js/scripts.js?ver=2.2.0"></script>
	<script src="./assets/js/charts/chart-ecommerce.js?ver=2.2.0"></script>
	
</body>

</html>