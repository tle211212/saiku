/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.saiku.service.license;

import bi.meteorite.license.LicenseException;
import bi.meteorite.license.SaikuLicense2;
import java.util.Date;

/**
 *
 * @author trunglt
 */
public class UnlimitedLicense extends SaikuLicense2 {
    @Override
    public void validate(Date currentDate, String currentVersion, boolean hostname, boolean ram, boolean version, boolean expiration) throws LicenseException {       
        return;
    }
    
    @Override
    public void validate(Date currentDate, String currentVersion) throws LicenseException {
        return;
    }
    
    @Override
    public String getEmail() {
        return "unlimited@unlimited.net";
    }
    
    @Override
    public Date getExpiration() {
        return new Date(2050, 6, 6);
    }
    
    @Override 
    public String getHostname() {
        return "*";
    }
    
    @Override
    public String getLicenseNumber() {
        return "999";
    }
    
    @Override
    public String getLicenseType() {
        return "full-maxmem";
    }
    
    @Override
    public int getMemoryLimit() {
        return 20000;
    }
        
    @Override
    public int getUserLimit() {
        return 20000;
    }
    
    @Override
    public String getName() {
        return "Unlimited license";
    }
    
    @Override
    public String getVersion() {
        return "3";
    }
}