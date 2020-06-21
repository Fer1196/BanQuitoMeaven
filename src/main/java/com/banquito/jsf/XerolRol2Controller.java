package com.banquito.jsf;

import com.banquito.jpa.XerolRol2;
import com.banquito.jsf.util.JsfUtil;
import com.banquito.jsf.util.JsfUtil.PersistAction;
import com.banquito.controladores.XerolRol2Facade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("xerolRol2Controller")
@SessionScoped
public class XerolRol2Controller implements Serializable {

    @EJB
    private com.banquito.controladores.XerolRol2Facade ejbFacade;
    private List<XerolRol2> items = null;
    private XerolRol2 selected;

    public XerolRol2Controller() {
    }

    public XerolRol2 getSelected() {
        return selected;
    }

    public void setSelected(XerolRol2 selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getXerolRol2PK().setPeempCodigo(selected.getXeusuUsuar().getPeempCodigo());
    }

    protected void initializeEmbeddableKey() {
        selected.setXerolRol2PK(new com.banquito.jpa.XerolRol2PK());
    }

    private XerolRol2Facade getFacade() {
        return ejbFacade;
    }

    public XerolRol2 prepareCreate() {
        selected = new XerolRol2();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("XerolRol2Created"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("XerolRol2Updated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("XerolRol2Deleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<XerolRol2> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public XerolRol2 getXerolRol2(com.banquito.jpa.XerolRol2PK id) {
        return getFacade().find(id);
    }

    public List<XerolRol2> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<XerolRol2> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = XerolRol2.class)
    public static class XerolRol2ControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            XerolRol2Controller controller = (XerolRol2Controller) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "xerolRol2Controller");
            return controller.getXerolRol2(getKey(value));
        }

        com.banquito.jpa.XerolRol2PK getKey(String value) {
            com.banquito.jpa.XerolRol2PK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.banquito.jpa.XerolRol2PK();
            key.setPeempCodigo(values[0]);
            key.setXeperCodper(values[1]);
            return key;
        }

        String getStringKey(com.banquito.jpa.XerolRol2PK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getPeempCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getXeperCodper());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof XerolRol2) {
                XerolRol2 o = (XerolRol2) object;
                return getStringKey(o.getXerolRol2PK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), XerolRol2.class.getName()});
                return null;
            }
        }

    }

}
