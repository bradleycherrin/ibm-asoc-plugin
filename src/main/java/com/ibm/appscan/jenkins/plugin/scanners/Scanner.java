/**
 * @ Copyright IBM Corporation 2016.
 * @ Copyright HCL Technologies Ltd. 2017.
 * LICENSE: Apache License, Version 2.0 https://www.apache.org/licenses/LICENSE-2.0
 */

package com.ibm.appscan.jenkins.plugin.scanners;

import hudson.model.AbstractDescribableImpl;
import hudson.util.VariableResolver;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Scanner extends AbstractDescribableImpl<Scanner> implements ScannerConstants, Serializable {

	private static final long serialVersionUID = 1L;
	
	private String m_target;
	private boolean m_hasOptions;
	
	public Scanner(String target, boolean hasOptions) {
		m_target = target;
		m_hasOptions = hasOptions;
	}
	
	public boolean getHasOptions() {
		return m_hasOptions;
	}
	
	public String getTarget() {
		return m_target;
	}
	
	public Map<String, String> getProperties(VariableResolver<String> resolver) {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put(TARGET,  resolver.resolve(m_target));
		return properties;
	}
	
	public abstract String getType();
}
