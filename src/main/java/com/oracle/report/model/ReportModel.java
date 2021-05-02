/*******************************************************************************
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 ******************************************************************************/

package com.oracle.report.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This is report model
 * 
 * @author vseth
 */
public class ReportModel {

   private Map <String, ContractModel> contractIDMap = new HashMap <>();
   private Map <String, GeoZoneModel>  geoZoneMap    = new HashMap <>();

   /**
    * @return the contractIDMap
    */
   public Map <String, ContractModel> getContractIDMap() {

      return contractIDMap;
   }

   /**
    * @return the geoZoneMap
    */
   public Map <String, GeoZoneModel> getGeoZoneMap() {

      return geoZoneMap;
   }

}
