/*******************************************************************************
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 ******************************************************************************/
package com.oracle.report.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will have common properties which can be extended by model
 * 
 * @author vseth
 */
public class BaseModel {

   List <String> customerIdList = new ArrayList <>();

   /**
    * @return the customerIdList
    */
   public List <String> getCustomerIdList() {

      return customerIdList;
   }

}
