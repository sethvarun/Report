/*******************************************************************************
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 ******************************************************************************/

package com.oracle.report.model;

/**
 * This represent the eachrow of the record.
 * 
 * @author vseth
 */
public class RecordModel {

   private String customerId;
   private String contractId;
   private String geozone;
   private String teamcode;
   private String projectcode;
   private int    buildduration;

   /**
    * @param customerId
    * @param contractId
    * @param geozone
    * @param teamcode
    * @param projectcode
    * @param buildduration
    */
   public RecordModel( String customerId, String contractId, String geozone, String teamcode, String projectcode, int buildduration ) {

      super();
      this.customerId = customerId;
      this.contractId = contractId;
      this.geozone = geozone;
      this.teamcode = teamcode;
      this.projectcode = projectcode;
      this.buildduration = buildduration;
   }

   /**
    * @return the customerId
    */
   public String getCustomerId() {

      return customerId;
   }

   /**
    * @return the contractId
    */
   public String getContractId() {

      return contractId;
   }

   /**
    * @return the geozone
    */
   public String getGeozone() {

      return geozone;
   }

   /**
    * @return the teamcode
    */
   public String getTeamcode() {

      return teamcode;
   }

   /**
    * @return the projectcode
    */
   public String getProjectcode() {

      return projectcode;
   }

   /**
    * @return the buildduration
    */
   public int getBuildduration() {

      return buildduration;
   }

}
