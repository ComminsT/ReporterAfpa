<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="js">

<head>
    
    <meta charset="utf-8">
    <meta name="author" content="Softnio">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Fav Icon  -->
    <link rel="shortcut icon" href="./images/favicon.png">
    <!-- Page Title  -->
    <title>Connexion | Reporter</title>
    <!-- StyleSheets  -->
    <link rel="stylesheet" href="./assets/css/dashlite.css?ver=2.2.0">
    <link id="skin-default" rel="stylesheet" href="./assets/css/theme.css?ver=2.2.0">
</head>

<body class="nk-body bg-white npc-default pg-auth">
    <div class="nk-app-root">
        <!-- main @s -->
        <div class="nk-main ">
            <!-- wrap @s -->
            <div class="nk-wrap nk-wrap-nosidebar">
                <!-- content @s -->
                <div class="nk-content ">
                    <div class="nk-block nk-block-middle nk-auth-body  wide-xs">
                        <div class="brand-logo pb-4 text-center">
                            <a class="logo-link">
                                <img class="logo-light logo-img logo-img-lg" src="./images/afpa1.png" srcset="./images/afpa1.png 2x" alt="logo">
                                <img class="logo-dark logo-img logo-img-lg" src="./images/afpa1.png" srcset="./images/afpa1.png 2x" alt="logo-dark">
                            </a>
                        </div>
                        <div class="card">
                            <div class="card-inner card-inner-lg">
                                <div class="nk-block-head">
                                    <div class="nk-block-head-content">
                                        <h4 class="nk-block-title">Connexion</h4>
                                        
                                    </div>
                                </div>
                                <form method="POST">
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <label class="form-label" for="default-01">Identifiant</label>
                                        </div>
                                        <input name="identifiant" type="text" class="form-control form-control-lg" id="default-01" placeholder="Entrez votre adresse identifiant">
                                    </div>
                                    <div class="form-group">
                                        <div class="form-label-group">
                                            <label class="form-label" for="password">Mot de passe</label>
                                        </div>
                                        <div class="form-control-wrap">
                                            <a href="#" class="form-icon form-icon-right passcode-switch" data-target="password">
                                                <em class="passcode-icon icon-show icon ni ni-eye"></em>
                                                <em class="passcode-icon icon-hide icon ni ni-eye-off"></em>
                                            </a>
                                            <input name="pwd" type="password" class="form-control form-control-lg" id="password" placeholder="Entrez votre mot de passe">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <button name="login" class="btn btn-lg btn-primary btn-block">Se connecter</button>
                                    </div>
                                </form>
                                <%Boolean connectederror=(Boolean)request.getAttribute("connected");
                                
                                 if(connectederror){%>
                                <div class="example-alert">
                                                            <div class="alert alert-danger alert-icon alert-dismissible">
                                                                <em class="icon ni ni-cross-circle"></em> <strong>Erreur</strong>Veuillez vérifier vos informations ou prendre contact avec un administrateur<button class="close" data-dismiss="alert"></button></div>
                                                        </div>
                                                        <%}%>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <!-- wrap @e -->
            </div>
            <!-- content @e -->
        </div>
        <!-- main @e -->
    </div>
    <!-- app-root @e -->
    <!-- JavaScript -->
    <script src="./assets/js/bundle.js?ver=2.2.0"></script>
    <script src="./assets/js/scripts.js?ver=2.2.0"></script>

</html>
