package com.cemgunduz.infonalqr.web.scope;

/**
 * Created by cgunduz on 1/28/14.
 */
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class ViewScope implements Scope {

    @Override
    @SuppressWarnings("rawtypes")
    public Object get(final String name, final ObjectFactory objectFactory) {
        final Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();

        if (viewMap.containsKey(name)) {
            Object bean = viewMap.get(name);

            // restore a transient autowired beans after re-serialization bean
            WebApplicationContext webAppContext = ContextLoader.getCurrentWebApplicationContext();

            if (webAppContext.containsBean(name)) {

                // Reconfigure restored bean instance.
                AutowireCapableBeanFactory autowireFactory = webAppContext.getAutowireCapableBeanFactory();
                bean = autowireFactory.configureBean(bean, name);
            }
            // end restore
            return bean;
        } else {
            final Object object = objectFactory.getObject();
            viewMap.put(name, object);

            return object;
        }
    }

    @Override
    public String getConversationId() {
        return null;
    }

    @Override
    public void registerDestructionCallback(final String name, final Runnable callback) {
        // Not supported
    }

    @Override
    public Object remove(final String name) {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
    }

    @Override
    public Object resolveContextualObject(final String key) {
        return null;
    }
}
