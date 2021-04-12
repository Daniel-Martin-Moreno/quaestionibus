package es.senda.preguntas.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CORSFilter.class); 

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest requestToUse = (HttpServletRequest) arg0;
		HttpServletResponse responseToUse = (HttpServletResponse) arg1;
		
		responseToUse.setHeader("Access-Control-Allow-Origin",requestToUse.getHeader("Origin"));
		responseToUse.setHeader("Access-Control-Allow-Methods","GET, POST, PUT, DELETE");
		responseToUse.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
		arg2.doFilter(requestToUse, responseToUse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOGGER.info("Inicializando CORSFilter");
		
	}

}
