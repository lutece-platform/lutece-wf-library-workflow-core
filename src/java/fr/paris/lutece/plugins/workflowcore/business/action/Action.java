/*
 * Copyright (c) 2002-2021, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.workflowcore.business.action;

import fr.paris.lutece.plugins.workflowcore.business.IReferenceItem;
import fr.paris.lutece.plugins.workflowcore.business.icon.Icon;
import fr.paris.lutece.plugins.workflowcore.business.state.State;
import fr.paris.lutece.plugins.workflowcore.business.workflow.Workflow;
import fr.paris.lutece.portal.service.rbac.RBACResource;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.paris.lutece.plugins.workflowcore.service.task.ITask;
import java.util.List;

/**
 * Action Object
 */
@JsonIgnoreProperties( ignoreUnknown = true )
public class Action implements RBACResource, IReferenceItem
{
    public static final String RESOURCE_TYPE = "WORKFLOW_ACTION_TYPE";

    // Variables declarations
    @JsonIgnore
    private int _nId;
    private String _strUid;
    private String _strName;
    private String _strDescription;
    private Icon _icon;
    @JsonIgnore
    private State _stateAfter;
    @JsonIgnore
    private State _alternativeStateAfter;
    @JsonIgnore
    private Workflow _workflow;
    private boolean _bAutomaticState;
    private boolean _bIsMassAction;
    @JsonIgnore
    private Collection<Integer> _listIdsLinkedAction;
    private Collection<String> _listUidsLinkedAction;
    private String _strUidStateAfter;
    private String _strUidAlternativeStateAfter;
    @JsonIgnore
    private List<ITask> _listTasks;
    private int _nOrder;
    private boolean _bAutomaticReflexiveAction;
    @JsonIgnore
    private List<Integer> _listIdStateBefore;
    private List<String> _listUidStateBefore;

    /**
     *
     * @return the id of the workflow action
     */
    @JsonIgnore
    public int getId( )
    {
        return _nId;
    }

    /**
     * set the id of the workflow action
     * 
     * @param idAction
     *            the id of the workflow action
     */
    @JsonIgnore
    public void setId( int idAction )
    {
        _nId = idAction;
    }
    
    /**
    *
    * @return the uid of the workflow action
    */
   public String getUid( )
   {
       return _strUid;
   }

   /**
    * set the uid of the workflow action
    * 
    * @param uidAction
    *            the uid of the workflow action
    */
   public void setUid( String strUid )
   {
	   _strUid = strUid;
   }

    /**
     * Returns the action name
     *
     * @return the action name
     */
    public String getName( )
    {
        return _strName;
    }

    /**
     * Set the action name
     *
     * @param strName
     *            the action name
     */
    public void setName( String strName )
    {
        _strName = strName;
    }

    /**
     * Returns the action description
     *
     * @return the action description
     */
    public String getDescription( )
    {
        return _strDescription;
    }

    /**
     * Set the action description
     *
     * @param strDescription
     *            The Description
     */
    public void setDescription( String strDescription )
    {
        _strDescription = strDescription;
    }

    /**
     * Returns the action icon
     *
     * @return The Icon
     */
    public Icon getIcon( )
    {
        return _icon;
    }

    /**
     * Set the action icon
     *
     * @param icon
     *            the icon
     */
    public void setIcon( Icon icon )
    {
        _icon = icon;
    }

    /**
     * Returns the State of the document after processing the action
     * 
     * @return The StateAfter
     */
    @JsonIgnore
    public State getStateAfter( )
    {
        return _stateAfter;
    }

    /**
     * Set the State to set after processing the action
     * 
     * @param stateAfter
     *            The StateAfter
     */
    @JsonIgnore
    public void setStateAfter( State stateAfter )
    {
        _stateAfter = stateAfter;
    }

    /**
     * Returns the alternative State to set when a task returns false
     * 
     * @return The StateAfterFailure
     */
    @JsonIgnore
    public State getAlternativeStateAfter( )
    {
        return _alternativeStateAfter;
    }

    /**
     * Set the State to set after processing the action (when the action returns false)
     * 
     * @param alternativeStateAfter
     *            The alternative StateAfter
     */
    @JsonIgnore
    public void setAlternativeStateAfter( State alternativeStateAfter )
    {
        _alternativeStateAfter = alternativeStateAfter;
    }

    
    /**
     * RBAC resource implementation
     * 
     * @return The resource type code
     */
    public String getResourceTypeCode( )
    {
        return RESOURCE_TYPE;
    }

    /**
     * RBAC resource implmentation
     * 
     * @return The resourceId
     */
    @JsonIgnore
    public String getResourceId( )
    {
        return Integer.toString( _nId );
    }

    /**
     *
     * @return the workflow associated
     */
    @JsonIgnore
    public Workflow getWorkflow( )
    {
        return _workflow;
    }

    /**
     * set the the workflow associated
     * 
     * @param workflow
     *            the workflow associated
     */
    @JsonIgnore
    public void setWorkflow( Workflow workflow )
    {
        _workflow = workflow;
    }

    /**
     *
     * @return return true if the resources of this state shall be assigned to a workgroup
     */
    public boolean isAutomaticState( )
    {
        return _bAutomaticState;
    }

    /**
     * set true return true if the resources of this state is automatic
     * 
     * @param automaticState
     *            true return true if the state is automatic
     */
    public void setAutomaticState( Boolean automaticState )
    {
        _bAutomaticState = automaticState;
    }

    /**
     * Set the attribute mass action
     * 
     * @param bIsMassAction
     *            true if the action is a mass action, false otherwise
     */
    public void setMassAction( boolean bIsMassAction )
    {
        _bIsMassAction = bIsMassAction;
    }

    /**
     * Check if the action is a mass action
     * 
     * @return true if it is a mass action, false otherwise
     */
    public boolean isMassAction( )
    {
        return _bIsMassAction;
    }

    /**
     * @param listIdsLinkedAction
     *            the _listIdsLinkedAction to set
     */
    @JsonIgnore
    public void setListIdsLinkedAction( Collection<Integer> listIdsLinkedAction )
    {
        _listIdsLinkedAction = listIdsLinkedAction;
    }

    /**
     * @return the _listIdsLinkedAction
     */
    @JsonIgnore
    public Collection<Integer> getListIdsLinkedAction( )
    {
        return _listIdsLinkedAction;
    }
    
    /**
     * @param listUidsLinkedAction
     *            the _listUidsLinkedAction to set
     */
    public void setListUidsLinkedAction( Collection<String> listUidsLinkedAction )
    {
        _listUidsLinkedAction = listUidsLinkedAction;
    }

    /**
     * @return the _listUidsLinkedAction
     */
    public Collection<String> getListUidsLinkedAction( )
    {
        return _listUidsLinkedAction;
    }
    

	/**
	 * @return the _strUidStateAfter
	 */
	public String getStrUidStateAfter() {
		return _strUidStateAfter;
	}

    /**
     * set the uid of the state after associated to the action
     * 
     * @param listStateBefore
     *            the list of all state before
     */
	public void setStrUidStateAfter(String strUidStateAfter) {
		_strUidStateAfter = strUidStateAfter;
	}

	/**
	 * @return the _strUidAlternativeStateAfter
	 */
	public String getStrUidAlternativeStateAfter() {
		return _strUidAlternativeStateAfter;
	}

    /**
     * set the uid of the alternative state after associated to the action
     * 
     * @param listStateBefore
     *            the list of all state before
     */
	public void setStrUidAlternativeStateAfter(String strUidAlternativeStateAfter) {
		_strUidAlternativeStateAfter = strUidAlternativeStateAfter;
	}

    /**
     * get the order of an action
     * 
     * @return the order of the action (to display in lists)
     */
    public int getOrder( )
    {
        return _nOrder;
    }

    /**
     * set the order of an action
     * 
     * @param nOrder
     *            the order to set
     */
    public void setOrder( int nOrder )
    {
        this._nOrder = nOrder;
    }

    /**
     * Check if this action is an automatic reflexive action
     * 
     * @return True if this action is an automatic reflexive action false otherwise.
     */
    public boolean isAutomaticReflexiveAction( )
    {
        return _bAutomaticReflexiveAction;
    }

    /**
     * Set whether this action is an automatic reflexive action
     * 
     * @param bAutomaticReflexiveAction
     *            True if this action is an automatic reflexive action false otherwise.
     */
    public void setAutomaticReflexiveAction( boolean bAutomaticReflexiveAction )
    {
        _bAutomaticReflexiveAction = bAutomaticReflexiveAction;
    }
    
    /**
     * set the list of all tasks associated to the action
     * 
     * @param listTasks
     *            the list of all tasks
     */
    @JsonIgnore
    public void setAllTasks( List<ITask> listTasks )
    {
        _listTasks = listTasks;
    }
    
    /**
     * get the list of all tasks associated to the action
     * 
     * @return 
     *         the list of all tasks associated to the action
     */
    @JsonIgnore
    public List<ITask> getAllTasks( )
    {
        return _listTasks ;
    }
    
    /**
     * get the list of all state before associated to the action
     * 
     * @return 
     *         the list of all state before associated to the action
     */
    @JsonIgnore
    public List<Integer> getListIdStateBefore() {
		return _listIdStateBefore;
	}

    /**
     * set the list of all state before associated to the action
     * 
     * @param listStateBefore
     *            the list of all state before
     */
    @JsonIgnore
	public void setListIdStateBefore(List<Integer> listIdStateBefore) {
		this._listIdStateBefore = listIdStateBefore;
	}
	
    /**
     * get the list of all state before associated to the action
     * 
     * @return 
     *         the list of all state before associated to the action
     */
    public List<String> getListUidStateBefore() {
		return _listUidStateBefore;
	}

    /**
     * set the list of all state before associated to the action
     * 
     * @param listStateBefore
     *            the list of all state before
     */
	public void setListUidStateBefore(List<String> listUidStateBefore) {
		this._listUidStateBefore = listUidStateBefore;
	}
}
