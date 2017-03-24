$(function() {
	$("#need_help_desktop").click(function(a) {
		a.stopPropagation()
	});

	$("#need_help_desktop .tab_help_open")
			.click(
					function(a) {
						a.stopPropagation();
						if ($(window).width() <= 767) {
							$("#need_help_popup").css("top", "132px").show()
						} else {
							if ($(this).hasClass("close")) {
								$("#need_help_desktop").animate({
									right : -250
								});
								$(
										"#need_help_desktop #need_help_popup,#need_help_desktop .tab_help_open")
										.animate(
												{
													height : 182
												},
												function(){$("#need_help_desktop .tab_help_open").removeClass("close")})}
							else {
								$("#need_help_desktop").animate({
									right : 0
								});
								$("#need_help_desktop .tab_help_open")
										.animate(
												{
													height : 258
												},
												function() {
													$(
															"#need_help_desktop .tab_help_open")
															.addClass("close")
												});
								$("#need_help_desktop #need_help_popup")
										.animate({
											height : 258
										})
							}
						}
					});
	$("body")
			.click(
					function() {
						$("#need_help_desktop").animate({
							right : -250
						});
						$(
								"#need_help_desktop #need_help_popup,#need_help_desktop .tab_help_open")
								.animate({
									height : 182
								});
						$("#need_help_desktop .tab_help_open").removeClass(
								"close")
					})
});