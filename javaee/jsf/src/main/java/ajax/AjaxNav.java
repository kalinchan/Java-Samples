package ajax;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AjaxNav implements Serializable {
	private static Logger LOGGER = Logger.getLogger(AjaxNav.class.getName());
	private static final long serialVersionUID = 1L;
	private String page;

	@PostConstruct
	public void init() {
		page = "home";
		LOGGER.info("Bean initialized");
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
		LOGGER.info("Page set to:" + page);
	}
}
