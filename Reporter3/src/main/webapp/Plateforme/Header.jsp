<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="nk-header nk-header-fixed is-light">
					<div class="container-fluid">
						<div class="nk-header-wrap">
							<div class="nk-menu-trigger d-xl-none ml-n1">
								<a href="#" class="nk-nav-toggle nk-quick-nav-icon"
									data-target="sidebarMenu"><em class="icon ni ni-menu"></em></a>
							</div>
							
							<!-- .nk-header-brand -->
							<!-- .nk-header-news -->

							<div class="nk-header-tools">
								<ul class="nk-quick-nav">
									
									
									<li class="dropdown user-dropdown"><a href="#"
										class="dropdown-toggle mr-n1" data-toggle="dropdown">
											<div class="user-toggle">
												<div class="user-avatar sm">
													<em class="icon ni ni-user-alt"></em>
												</div>
												<div class="user-info d-none d-xl-block">
													<div class="user-status user-status-unverified">${groupe}</div>
													<div class="user-name dropdown-indicator">${usernname}</div>
												</div>
											</div>
									</a>
										<div
											class="dropdown-menu dropdown-menu-md dropdown-menu-right">
											<div
												class="dropdown-inner user-card-wrap bg-lighter d-none d-md-block">
												<div class="user-card">
													<div class="user-avatar">
														<span>${currentuser.getNom().substring(0,1)}${currentuser.getPrenom().substring(0,1)}</span>
													</div>
													<div class="user-info">
														<span class="lead-text">${usernname}</span> <span
															class="sub-text">${currentuser.getMail()}</span>
													</div>
												</div>
											</div>
											<div class="dropdown-inner">
												<ul class="link-list">
													<li><button type="button" class="btn btn-sm btn-secondary"
																				data-toggle="modal" data-target="#modal">Changer de mot de passe
																				</button>
												</ul>
											</div>
											<div class="dropdown-inner">
												<ul class="link-list">
													<li><a href="Disconnection"><em class="icon ni ni-signout"></em><span>Déconnexion</span></a></li>
												</ul>
											</div>
										</div></li>
								</ul>
							</div>
						</div>
						<!-- .nk-header-wrap -->
					</div>
					<!-- .container-fliud -->
				</div>
				
				
				<!-- Modal changement de mdp -->
				<div class="modal fade" tabindex="-1" id="modal">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Changement de mdp</h5>
					<a href="#" class="close" data-dismiss="modal" aria-label="Close">
						<em class="icon ni ni-cross"></em>
					</a>
				</div>
				<div class="modal-body">
					<form method="POST" class="gy-3" data-parsley-validate="">
						<div class="row g-3 align-center">
							<div class="col-lg-5">
								<div class="form-group">
									<label class="form-label">Mdp actuel</label>
								</div>
							</div>

						</div>
						<div class="col-lg-7">
																	<div class="form-group">
																		<div class="form-control-wrap">
																			<input required type="text" class="form-control"
																				id="site-name" name="mdp"
																				placeholder="Votre mdp actuel"
																				value="">
																		</div>
																	</div>
																</div>
						
						<div class="row g-3 align-center">
							<div class="col-lg-5">
								<div class="form-group">
									<label class="form-label">Nouveau mdp</label>
								</div>
							</div>

						</div>
						<div class="col-lg-7">
								<div class="form-group">
									<div class="form-control-wrap">
										<input required type="text" class="form-control"
											id="site-name" name="newmdp"
											placeholder="Votre nouveau mdp"
											value="">
									</div>
								</div>
							</div>
						<div class="row g-3">
							<div class="col-lg-7 offset-lg-5">
								<div class="form-group mt-2">
									<button name="changemdp"
										class="btn btn-lg btn-primary">Valider</button>
								</div>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
				
				
				