<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<div class="branches_container" style="margin-top: 112px">
		<div class="container p-0">
			<div class="row">
				<section class="col col-3 branches_sidebar">
					<ul class="branches_sidebar_list">
						<c:forEach var="city" items="${cities}">
							<li class="branches_sidebar_item"><a
								class='branches_sidebar_item_link ${city.idCity == idCity? "
								branches_sidebar_item_link--active":""}'
								href="/branches/${city.idCity}">${city.name}(${city.getBranches().size()})</a>
							</li>
						</c:forEach>
					</ul>
				</section>
				<c:forEach var="city" items="${cities}">
					<c:if test="${city.idCity == idCity}">
						<section class="branches col col-9">
							<div class="container">
								<div class="row gx-5">
									<c:forEach var="branch" items="${city.getBranches()}">
										<div class="col col-6 branch-item">
											<div class="branch">
												<div class="branch_image-container">
													<c:url
														value="/branches/image/${branch.image != null ? branch.image : null }"
														var="imgUrl" />
													<img
														src="${imgUrl}"
														class="branch-image" />
													<div class="branch-slide"></div>
												</div>
												<div class="branch_body">
													<h3 class="branch_name">${branch.name }</h3>
													<a class="branch_btn"
														href="/branch-info/${branch.idBranch}"> <span>Xem
															chi tiết</span>
													</a>
													<div class="branch_society">
														<ul class="branch_society_list">
															<li class="branch_society_item"><i
																class="fa-brands fa-facebook"></i></li>
															<li class="branch_society_item"><i
																class="fa-brands fa-square-instagram"></i></li>
															<li class="branch_society_item"><i
																class="fa-brands fa-linkedin"></i></li>
															<li class="branch_society_item"><i
																class="fa-brands fa-twitter"></i></li>
														</ul>
													</div>
													<div class="branch_desc">
														<p>
															<b>Địa chỉ:</b>${branch.addressDetail}
														</p>
														<p>
															<b>Mở cửa:</b> ${branch.opentime}
														</p>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
								<div class="branch_see_more">Xem Thêm</div>
							</div>
						</section>
					</c:if>
				</c:forEach>


			</div>
		</div>

	</div>
	<script type="text/javascript"
		src='<c:url value="/user/js/branches.js" />'></script>
</body>
</html>
