package dz.app.automation;

import java.io.Serializable;

/**
 *
 * @author abdessamed.diab
 */
public interface Test extends Serializable{
    public static final String DEFAULT_LOCAL_REPOSITORY="c://";
    
    public void isAccessGranted();
    
}
