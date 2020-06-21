package com.banquito.jsf;

import com.banquito.jpa.XeperPerfil2;
import com.banquito.jsf.util.JsfUtil;
import com.banquito.jsf.util.JsfUtil.PersistAction;
import com.banquito.controladores.XeperPerfil2Facade;

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

@Named("xeperPerfil2Controller")
@SessionScoped
public class XeperPerfil2Controller implements Serializable {

    @EJB
    private com.banquito.controladores.XeperPerfil2Facade ejbFacade;
    private List<XeperPerfil2> items = null;
    private XeperPerfil2 selected;

    public XeperPerfil2Controller() {
    }

    public XeperPerfil2 getSelected() {
        return selected;
    }

    public void setSelected(XeperPerfil2 selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private XeperPerfil2Facade getFacade() {
        return ejbFacade;
    }

    public XeperPerfil2 prepareCreate() {
        selected = new XeperPerfil2();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("XeperPerfil2Created"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("XeperPerfil2Updated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("XeperPerfil2Deleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<XeperPerfil2> getItems() {
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

    public XeperPerfil2 getXeperPerfil2(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<XeperPerfil2> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<XeperPerfil2> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = XeperPerfil2.class)
    public static class XeperPerfil2ControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            XeperPerfil2Controller controller = (XeperPerfil2Controller) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "xeperPerfil2Controller");
            return controller.getXeperPerfil2(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof XeperPerfil2) {
                XeperPerfil2 o = (XeperPerfil2) object;
                return getStringKey(o.getXeperCodper());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), XeperPerfil2.class.getName()});
                return null;
            }
        }

    }

}
