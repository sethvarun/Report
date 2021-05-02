/*******************************************************************************
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 ******************************************************************************/

package com.oracle.report.model;

/**
 *  Model for data to store as per geoZone
 * @author vseth
 *
 */

public class GeoZoneModel extends BaseModel {

   double avgBuildDuraion;
   int    totalRecords;

   /**
    * @return the avgBuildDuraion
    */
   public double getAvgBuildDuraion() {

      return avgBuildDuraion;
   }

   /**
    * @param avgBuildDuraion
    *           the avgBuildDuraion to set
    */
   public void setAvgBuildDuraion( double avgBuildDuraion ) {

      this.avgBuildDuraion = avgBuildDuraion;
   }

   /**
    * @return the totalRecords
    */
   public int getTotalRecords() {

      return totalRecords;
   }

   /**
    * @param totalRecords
    *           the totalRecords to set
    */
   public void setTotalRecords( int totalRecords ) {

      this.totalRecords = totalRecords;
   }
}