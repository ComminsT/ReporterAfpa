<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="models.Utilisateur"%>
    <%@page import="models.Groupe"%>
    <%@page import="models.Group_list"%>
    <%@page import="java.util.ArrayList"%>
    <%ArrayList<Groupe>groupes = (ArrayList<Groupe>)request.getAttribute("groupes"); %>
    

    <!DOCTYPE html>
<html lang="UTF-8" class="js">

<head>
    <base href="../">
    <meta charset="utf-8">
    <meta name="author" content="Softnio">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="A powerful and conceptual apps base dashboard template that especially build for developers and programmers.">
    <!-- Fav Icon  -->
    <link rel="shortcut icon" href="./images/favicon.png">
    <!-- Page Title  -->
    <title>Afpa - Nouvelle action</title>
    <!-- StyleSheets  -->
    <link rel="stylesheet" href="./assets/css/dashlite.css?ver=2.2.0">
    <link id="skin-default" rel="stylesheet" href="./assets/css/theme.css?ver=2.2.0">
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>


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
                                            <h4 class="title nk-block-title">Nouvel Utilisateur</h4>
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
                                                                            <label class="form-label" for="site-name">Groupe d'utilisateur</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-lg-7">
                                                                        <div class="g-4 align-center flex-wrap">
                                                                            <%for(Groupe g:groupes){ %>
                                                                            <div class="g">
                                                                                <div class="custom-control custom-control-lg custom-radio">
                                                                                    <input type="radio" class="custom-control-input" name="type" checked id="customRadio<%=g.getId()%>" value="<%=g.getId()%>">
                                                                                    <label class="custom-control-label" for="customRadio<%=g.getId()%>"><%=g.getTitre()%></label>
                                                                                </div>
                                                                            </div>
                                                                            <%}%>
                                                                            
                                                                            
                                                                        </div>
                                                                        
                                                                        
                                                                    </div>
                                                                </div>
                                                                <div class="row g-3 align-center">
                                                                    <div class="col-lg-5">
                                                                        <div class="form-group">
                                                                            <label class="form-label" for="site-name">Nom</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-lg-7">
                                                                        <div class="form-group">
                                                                            <div class="form-control-wrap">
                                                                                <input name="nom" type="text" class="form-control" id="site-name" value="" placeholder="Nom">
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="row g-3 align-center">
                                                                    <div class="col-lg-5">
                                                                        <div class="form-group">
                                                                            <label class="form-label" for="site-name">Prenom</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-lg-7">
                                                                        <div class="form-group">
                                                                            <div class="form-control-wrap">
                                                                                <input name="prenom" type="text" class="form-control" id="site-name" value="" placeholder="Prenom">
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="row g-3 align-center">
                                                                    <div class="col-lg-5">
                                                                        <div class="form-group">
                                                                            <label class="form-label" for="site-name">Identifiant</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-lg-7">
                                                                        <div class="form-group">
                                                                            <div class="form-control-wrap">
                                                                                <input name="identifiant" type="text" class="form-control" id="site-name" value="" placeholder="Identifiant">
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="row g-3 align-center">
                                                                    <div class="col-lg-5">
                                                                        <div class="form-group">
                                                                            <label class="form-label" for="site-name">Mail</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-lg-7">
                                                                        <div class="form-group">
                                                                            <div class="form-control-wrap">
                                                                                <input name="mail" type="text" class="form-control" id="site-name" value="" placeholder="Mail">
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="row g-3 align-center">
                                                                    <div class="col-lg-5">
                                                                        <div class="form-group">
                                                                            <label class="form-label" for="site-name">Mot de passe</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-lg-7">
                                                                        <div class="form-group">
                                                                            <div class="form-control-wrap">
                                                                                <input name="password" type="text" class="form-control" id="site-name" value="">
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                
                                                                <div class="row g-3">
                                                                    <div class="col-lg-7 offset-lg-5">
                                                                        <div class="form-group mt-2">
                                                                            <button name="save" type="submit" class="btn btn-lg btn-primary">Confirmer</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div><!-- card -->
                                        </div>
                                    </div><!-- .card-preview -->
                                    
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
    
    
        
            
        
</body>

</html>