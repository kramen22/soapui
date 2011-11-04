/*
 *  soapUI, copyright (C) 2004-2011 eviware.com 
 *
 *  soapUI is free software; you can redistribute it and/or modify it under the 
 *  terms of version 2.1 of the GNU Lesser General Public License as published by 
 *  the Free Software Foundation.
 *
 *  soapUI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details at gnu.org.
 */
package com.eviware.soapui.impl.wsdl.panels.assertions;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import com.eviware.soapui.impl.wsdl.teststeps.assertions.TestAssertionRegistry;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.basic.GroovyScriptAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.basic.ResponseSLAAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.basic.SchemaComplianceAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.basic.SimpleContainsAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.basic.SimpleNotContainsAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.basic.XPathContainsAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.basic.XQueryContainsAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.jms.JMSStatusAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.jms.JMSTimeoutAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.soap.NotSoapFaultAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.soap.SoapFaultAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.soap.SoapResponseAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.soap.WSAResponseAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.soap.WSSStatusAssertion;
import com.eviware.soapui.model.testsuite.Assertable;
import com.eviware.soapui.security.assertion.InvalidHttpStatusCodesAssertion;
import com.eviware.soapui.security.assertion.SensitiveInfoExposureAssertion;
import com.eviware.soapui.security.assertion.ValidHttpStatusCodesAssertion;

public class AssertionCategoryMapping
{
	private final static String VALIDATE_RESPONSE_CONTENT_CATEGORY = "Validate Response Content";
	private final static String STATUS_CATEGORY = "Compliance, Status and Standards";
	private final static String SCRIPT_CATEGORY = "Script";
	private final static String SLA_CATEGORY = "SLA";
	private final static String JMS_CATEGORY = "JMS";
	private final static String SECURITY_CATEGORY = "Security";

	public static String[] getAssertionCategories()
	{
		return new String[] { VALIDATE_RESPONSE_CONTENT_CATEGORY, STATUS_CATEGORY, SCRIPT_CATEGORY, SLA_CATEGORY,
				JMS_CATEGORY, SECURITY_CATEGORY };
	}

	public static LinkedHashMap<String, LinkedHashSet<String>> getCategoriesAssertionsMap( Assertable assertable )
	{
		LinkedHashMap<String, LinkedHashSet<String>> categoriesAssertionsMap = new LinkedHashMap<String, LinkedHashSet<String>>();
		String[] assertions = TestAssertionRegistry.getInstance().getAvailableAssertionNames( assertable );

		LinkedHashSet<String> validatingResponseAssertionsSet = new LinkedHashSet<String>();
		for( String availableAssertion : assertions )
		{
			if( availableAssertion.equals( XPathContainsAssertion.LABEL ) )
			{
				validatingResponseAssertionsSet.add( availableAssertion );
			}
			if( availableAssertion.equals( XQueryContainsAssertion.LABEL ) )
			{
				validatingResponseAssertionsSet.add( availableAssertion );
			}
			if( availableAssertion.equals( SimpleContainsAssertion.LABEL ) )
			{
				validatingResponseAssertionsSet.add( availableAssertion );
			}
			if( availableAssertion.equals( SimpleNotContainsAssertion.LABEL ) )
			{
				validatingResponseAssertionsSet.add( availableAssertion );
			}
		}
		if( validatingResponseAssertionsSet.size() > 0 )
			categoriesAssertionsMap.put( VALIDATE_RESPONSE_CONTENT_CATEGORY, validatingResponseAssertionsSet );

		LinkedHashSet<String> statusAssertionsSet = new LinkedHashSet<String>();
		for( String availableAssertion : assertions )
		{
			if( availableAssertion.equals( InvalidHttpStatusCodesAssertion.LABEL ) )
			{
				statusAssertionsSet.add( availableAssertion );
			}
			if( availableAssertion.equals( WSSStatusAssertion.LABEL ) )
			{
				statusAssertionsSet.add( availableAssertion );
			}
			if( availableAssertion.equals( NotSoapFaultAssertion.LABEL ) )
			{
				statusAssertionsSet.add( availableAssertion );
			}
			if( availableAssertion.equals( ValidHttpStatusCodesAssertion.LABEL ) )
			{
				statusAssertionsSet.add( availableAssertion );
			}
			if( availableAssertion.equals( SoapResponseAssertion.LABEL ) )
			{
				statusAssertionsSet.add( availableAssertion );
			}
			if( availableAssertion.equals( WSAResponseAssertion.LABEL ) )
			{
				statusAssertionsSet.add( availableAssertion );
			}
			if( availableAssertion.equals( SchemaComplianceAssertion.LABEL ) )
			{
				statusAssertionsSet.add( availableAssertion );
			}
			if( availableAssertion.equals( SoapFaultAssertion.LABEL ) )
			{
				statusAssertionsSet.add( availableAssertion );
			}
		}
		if( statusAssertionsSet.size() > 0 )
			categoriesAssertionsMap.put( STATUS_CATEGORY, statusAssertionsSet );

		LinkedHashSet<String> scriptAssertionsSet = new LinkedHashSet<String>();
		for( String availableAssertion : assertions )
		{
			if( availableAssertion.equals( GroovyScriptAssertion.LABEL ) )
			{
				scriptAssertionsSet.add( availableAssertion );
			}
		}
		if( scriptAssertionsSet.size() > 0 )
			categoriesAssertionsMap.put( SCRIPT_CATEGORY, scriptAssertionsSet );

		LinkedHashSet<String> slaAssertionsSet = new LinkedHashSet<String>();
		for( String availableAssertion : assertions )
		{
			if( availableAssertion.equals( ResponseSLAAssertion.LABEL ) )
			{
				slaAssertionsSet.add( availableAssertion );
			}
		}
		if( slaAssertionsSet.size() > 0 )
			categoriesAssertionsMap.put( SLA_CATEGORY, slaAssertionsSet );

		LinkedHashSet<String> jmsAssertionsSet = new LinkedHashSet<String>();
		for( String availableAssertion : assertions )
		{
			if( availableAssertion.equals( JMSStatusAssertion.LABEL ) )
			{
				jmsAssertionsSet.add( availableAssertion );
			}
			if( availableAssertion.equals( JMSTimeoutAssertion.LABEL ) )
			{
				jmsAssertionsSet.add( availableAssertion );
			}
		}
		if( jmsAssertionsSet.size() > 0 )
			categoriesAssertionsMap.put( JMS_CATEGORY, jmsAssertionsSet );

		LinkedHashSet<String> securityAssertionsSet = new LinkedHashSet<String>();
		for( String availableAssertion : assertions )
		{
			if( availableAssertion.equals( SensitiveInfoExposureAssertion.LABEL ) )
			{
				securityAssertionsSet.add( availableAssertion );
			}
		}
		if( securityAssertionsSet.size() > 0 )
			categoriesAssertionsMap.put( SECURITY_CATEGORY, securityAssertionsSet );

		return categoriesAssertionsMap;
	}
}