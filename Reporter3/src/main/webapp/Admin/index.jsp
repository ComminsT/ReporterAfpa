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
			<jsp:include page="Sidebar"/>
			<!-- sidebar @e -->
			<!-- wrap @s -->
			<div class="nk-wrap ">
				<!-- main header @s -->
				<jsp:include page="Header" />
				<!-- main header @e -->
				<!-- content @s -->
				
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