package dz.app.loader;

import dz.app.automation.TestImpl;
import java.io.Serializable;
import java.util.List;

import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/**
 *
 * @author abdessamed.diab
 */
@Component("CustomAppContext")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CustomApplicationContext implements Serializable, InitializingBean{
    private static Logger log= LoggerFactory.getLogger(CustomApplicationContext.class);
    
    public CustomApplicationContext() {
        log.debug("constructor");
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        launchTest();
    }
    
    private boolean launchTest(){
        Result result= JUnitCore.runClasses(TestImpl.class);
        
        List<Failure> failures= result.getFailures();
        
        if(failures.size() > 0){
            for(Failure f: failures){
                log.error("failure", f.getException() );
            }
            
            return false;
        }
        
        return true;
    }

    
    
}
