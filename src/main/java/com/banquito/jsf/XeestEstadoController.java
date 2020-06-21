package com.banquito.jsf;

import com.banquito.jpa.XeestEstado;
import com.banquito.jsf.util.JsfUtil;
import com.banquito.jsf.util.JsfUtil.PersistAction;
import com.banquito.controladores.XeestEstadoFacade;

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

@Named("xeestEstadoController")
@SessionScoped
public class XeestEstadoController implements Serializable {

    @EJB
    private com.banquito.controladores.XeestEstadoFacade ejbFacade;
    private List<XeestEstado> items = null;
    private XeestEstado selected;

    public XeestEstadoController() {
    }

    public XeestEstado getSelected() {
        return selected;
    }

    public void setSelected(XeestEstado selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getXeestEstadoPK().setXeuPeempCodigo(selected.getXeusuUsuar().getPeempCodigo());
    }

    protected void initializeEmbeddableKey() {
        selected.setXeestEstadoPK(new com.banquito.jpa.XeestEstadoPK());
    }

    private XeestEstadoFacade getFacade() {
        return ejbFacade;
    }

    public XeestEstado prepareCreate() {
        selected = new XeestEstado();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("XeestEstadoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("XeestEstadoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("XeestEstadoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<XeestEstado> getItems() {
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

    public XeestEstado getXeestEstado(com.banquito.jpa.XeestEstadoPK id) {
        return getFacade().find(id);
    }

    public List<XeestEstado> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<XeestEstado> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = XeestEstado.class)
    public static class XeestEstadoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            XeestEstadoController controller = (XeestEstadoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "xeestEstadoController");
            return controller.getXeestEstado(getKey(value));
        }

        com.banquito.jpa.XeestEstadoPK getKey(String value) {
            com.banquito.jpa.XeestEstadoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.banquito.jpa.XeestEstadoPK();
            key.setXeuPeempCodigo(values[0]);
            key.setXeestCodigo(new Character(values[1].charAt(0)));
            return key;
        }

        String getStringKey(com.banquito.jpa.XeestEstadoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getXeuPeempCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getXeestCodigo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof XeestEstado) {
                XeestEstado o = (XeestEstado) object;
                return getStringKey(o.getXeestEstadoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), XeestEstado.class.getName()});
                return null;
            }
        }

    }

}
