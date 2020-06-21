package com.banquito.jsf;

import com.banquito.jpa.XeuxpUsuper;
import com.banquito.jsf.util.JsfUtil;
import com.banquito.jsf.util.JsfUtil.PersistAction;
import com.banquito.controladores.XeuxpUsuperFacade;

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

@Named("xeuxpUsuperController")
@SessionScoped
public class XeuxpUsuperController implements Serializable {

    @EJB
    private com.banquito.controladores.XeuxpUsuperFacade ejbFacade;
    private List<XeuxpUsuper> items = null;
    private XeuxpUsuper selected;

    public XeuxpUsuperController() {
    }

    public XeuxpUsuper getSelected() {
        return selected;
    }

    public void setSelected(XeuxpUsuper selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getXeuxpUsuperPK().setPeempCodigo(selected.getXeusuUsuar().getPeempCodigo());
    }

    protected void initializeEmbeddableKey() {
        selected.setXeuxpUsuperPK(new com.banquito.jpa.XeuxpUsuperPK());
    }

    private XeuxpUsuperFacade getFacade() {
        return ejbFacade;
    }

    public XeuxpUsuper prepareCreate() {
        selected = new XeuxpUsuper();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("XeuxpUsuperCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("XeuxpUsuperUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("XeuxpUsuperDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<XeuxpUsuper> getItems() {
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

    public XeuxpUsuper getXeuxpUsuper(com.banquito.jpa.XeuxpUsuperPK id) {
        return getFacade().find(id);
    }

    public List<XeuxpUsuper> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<XeuxpUsuper> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = XeuxpUsuper.class)
    public static class XeuxpUsuperControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            XeuxpUsuperController controller = (XeuxpUsuperController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "xeuxpUsuperController");
            return controller.getXeuxpUsuper(getKey(value));
        }

        com.banquito.jpa.XeuxpUsuperPK getKey(String value) {
            com.banquito.jpa.XeuxpUsuperPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.banquito.jpa.XeuxpUsuperPK();
            key.setPeempCodigo(values[0]);
            key.setXeuxpFecasi(java.sql.Date.valueOf(values[1]));
            return key;
        }

        String getStringKey(com.banquito.jpa.XeuxpUsuperPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getPeempCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getXeuxpFecasi());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof XeuxpUsuper) {
                XeuxpUsuper o = (XeuxpUsuper) object;
                return getStringKey(o.getXeuxpUsuperPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), XeuxpUsuper.class.getName()});
                return null;
            }
        }

    }

}
