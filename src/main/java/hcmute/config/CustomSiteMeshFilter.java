package hcmute.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;


public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter{
	//Cấu hình sitemesh 
	@Override
	public void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder
			//Áp dụng decorator cho các đường dẫn
			.addDecoratorPath("/*", "/decorators/user.jsp")
			.addDecoratorPath("/admin/*", "/decorators/admin.jsp")
			.addDecoratorPath("/manager/*", "/decorators/manager.jsp")
			//Loại trừ decorator khỏi đường dẫn này
			.addExcludedPath("/security*").addExcludedPath("/security/*");
	}
}
