<%@page import="models.Action"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="models.Utilisateur"%>
    <%@ page import="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html lang="zxx" class="js">

<head>
    <base href="../">
    <meta charset="utf-8">
    <meta name="author" content="Softnio">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="A powerful and conceptual apps base dashboard template that especially build for developers and programmers.">
    <!-- Fav Icon  -->
    <link rel="shortcut icon" href="./images/favicon.png">
    <!-- Page Title  -->
    <title>Afpa - Reporting plateforme</title>
    <!-- StyleSheets  -->
    <%Action action = (Action)request.getAttribute("action"); %>
    
</head>
<link rel="stylesheet" href="./assets/css/dashlite.css?ver=2.2.0">
    <link id="skin-default" rel="stylesheet" href="./assets/css/theme.css?ver=2.2.0">
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
                                            <h1 class="nk-block-title page-title">Reporting plateforme cible BtoB</h1>
                                        </div><!-- .nk-block-head-content -->
                                    </div><!-- .nk-block-between -->
                                </div><!-- .nk-block-head -->
                                <div class="nk-block nk-block-lg">
                                    <div class="nk-block-head">
                                        <div class="nk-block-head-content">
                                            <h4 class="nk-block-title"><%=action.getTheme() %> - Semaine <%=String.valueOf(action.getSemaine()).substring(4) %></h4>
                                        </div>
                                    </div>
                                            <div class="nk-block nk-block-lg">
                                                <div class="nk-block-head">
                                                </div>
                                                <div class="card">
                                                    <div class="card-inner">
                                                        <form method="POST" class="gy-3">
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label" for="site-name">Relance faite par</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-group">
                                                                        <div class="form-control-wrap">
                                                                            <select name="user" class="form-select"  >
                                                                            <%ArrayList<Utilisateur>utilisateurs= (ArrayList<Utilisateur>)request.getAttribute("utilisateurs"); 
                                                                            for(Utilisateur u:utilisateurs){
                                                                            %>
                                                                                <option value="<%=u.getId()%>"><%=u.getNom()+" "+u.getPrenom() %></option>
                                                                                <%} %>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                            </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Date de relance</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-group">
                                                                        <div class="form-control-wrap">
                                                                            <input required name="date" placeholder="Sélectionnez la date d'envoi" class="form-control date-picker datepicker " id="weeklyDatePicker">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre de contact rappelés</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-call
                                                                            "></em>
                                                                        </div>
                                                                        <input required name="nbrcontactrappele" type="number" class="form-control" id="default-04" placeholder="Entrez le nombre de contact rappelé">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre de contact argumentés</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-user-list
                                                                            "></em>
                                                                        </div>
                                                                        <input required name="nbrcontactargumente" type="number" class="form-control" id="default-04" placeholder="Entrez le nombre de contact argumentés">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre d'inscription en information collective</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-info-i

                                                                            "></em>
                                                                        </div>
                                                                        <input required name="nbrinscriptionic" type="number" class="form-control" id="default-04" placeholder="Entrez le nombre d'inscription en information collective">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            
                                                            <%if(action.getId_positionnement()==1){ %>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre d'envoi de catalogue</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-book-read


                                                                            "></em>
                                                                        </div>
                                                                        <input required name="nbrenvoicatalogue" type="number" class="form-control" id="default-04" placeholder="Entrez le nombre d'envoi de catalogue">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre d'inscription en événement</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-ticket
                                                                            "></em>
                                                                        </div>
                                                                        <input required name="nbrinscriptionevent" type="number" class="form-control" id="default-04" placeholder="Entrez le nombre d'inscription en événement">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre de prise de RDV</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-calendar-booking

                                                                            "></em>
                                                                        </div>
                                                                        <input required name="nbrrdv" type="number" class="form-control" id="default-04" placeholder="Entrez le nombre de prise de RDV">
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre de devis</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-sign-euro
                                                                            "></em>
                                                                        </div>
                                                                        <input required name="nbrdevis" type="number" class="form-control" id="default-04" placeholder="Entrez le nombre de devis">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Nombre de convention</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                        <div class="form-icon form-icon-right">
                                                                            <em class="icon ni ni-report-profit


                                                                            "></em>
                                                                        </div>
                                                                        <input required name="nbrconvention" type="number" class="form-control" id="default-04" placeholder="Entrez le nombre de convention">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row g-3 align-center">
                                                                <div class="col-lg-5">
                                                                    <div class="form-group">
                                                                        <label class="form-label">Commentaire</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-7">
                                                                    <div class="form-control-wrap">
                                                                            <div class="form-group">
                                                                                
                                                                                <div class="form-control-wrap">
                                                                                    <textarea name="commentaire" class="form-control form-control-simple no-resize border" placeholder="Entrez votre commentaire ici" id="default-textarea"></textarea>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    
                                                                </div>
                                                            </div>
                                                            <%}%>
                                                            <div class="row g-3">
                                                                <div class="col-lg-7 offset-lg-5">
                                                                    <div class="form-group mt-2">
                                                                        <button name="save" type="submit" class="btn btn-lg btn-primary">Enregistrer</button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div><!-- card -->
                                            </div><!-- .nk-block -->
                                    <!-- Debut tableau -->
                                    
                                </div> <!-- nk-block -->
                                
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
    <script src="jquery.js"></script>
    <script src="parsley.min.js"></script>
    <script src="./assets/js/bundle.js?ver=2.2.0"></script>
    <script src="./assets/js/scripts.js?ver=2.2.0"></script>
    <script src="./assets/js/charts/chart-ecommerce.js?ver=2.2.0"></script>
    
    <script>
        ;(function($){
        $.fn.datepicker.dates['fr'] = {
        days: ["dimanche", "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi"],
        daysShort: ["dim.", "lun.", "mar.", "mer.", "jeu.", "ven.", "sam."],
        daysMin: ["d", "l", "ma", "me", "j", "v", "s"],
        months: ["janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre"],
        monthsShort: ["janv.", "févr.", "mars", "avril", "mai", "juin", "juil.", "août", "sept.", "oct.", "nov.", "déc."],
        today: "Aujourd'hui",
        monthsTitle: "Mois",
        clear: "Effacer",
        weekStart: 1,
        format: "dd/mm/yyyy"
        };
        }(jQuery));
        
        $('.datepicker').datepicker({
        language: 'fr',
        autoclose: true,
        todayHighlight: true
        })
        
        </script>
</body>

</html>