/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.app.automation;

import java.io.File;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mechel178
 */
public class TestImpl implements Test{

    private static Logger log= LoggerFactory.getLogger(TestImpl.class);
    
    @Override
    @org.junit.Test
    public void isAccessGranted() {
        File file= new File(Test.DEFAULT_LOCAL_REPOSITORY);
        
        for(File f: file.listFiles())
            if(f.isFile()){
                log.info("file system access granted");
                assertTrue(true);
                return ;
            }
        
        log.info("file system access denied, "
                + "please see the secutity manager of the current Operating System");
        
        assertFalse(true);
    }
    
}
