package hcmute.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl {
	@Autowired
    HttpSession session;
    @SuppressWarnings("unchecked")
	public <T> T getAttribute(String name) {
  	  return (T) session.getAttribute(name);
    }
    public <T> T get(String name) {
    	T value = getAttribute(name);
  	  	return value;
  	  }
    public void setAttribute(String name,Object value) {
  	  session.setAttribute(name, value);
    }
    public void removeAttribute(String name) {
  	  session.removeAttribute(name);
    }
}
