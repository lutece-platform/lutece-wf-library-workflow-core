/*
 * Copyright (c) 2002-2020, City of Paris
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Action Object
 */
@JsonIgnoreProperties( ignoreUnknown = true )
public class Action implements RBACResource, IReferenceItem
{
    public static final String RESOURCE_TYPE = "WORKFLOW_ACTION_TYPE";

    // Variables declarations
    private int _nId;
    private String _strName;
    private String _strDescription;
    private Icon _icon;
    private State _stateBefore;
    private State _stateAfter;
    private Workflow _workflow;
    private boolean _bAutomaticState;
    private boolean _bIsMassAction;
    private Collection<Integer> _listIdsLinkedAction;
    private int _nOrder;
    private boolean _bAutomaticReflexiveAction;

    /**
     *
     * @return the id of the workflow action
     */
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
    public void setId( int idAction )
    {
        _nId = idAction;
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
     * Return the State of the document before processing the action
     * 
     * @return The StateBefore
     */
    public State getStateBefore( )
    {
        return _stateBefore;
    }

    /**
     * Set the State of the document before processing the action
     * 
     * @param stateBefore
     *            The StateBefore
     */
    public void setStateBefore( State stateBefore )
    {
        _stateBefore = stateBefore;
    }

    /**
     * Returns the State of the document after processing the action
     * 
     * @return The StateAfter
     */
    public State getStateAfter( )
    {
        return _stateAfter;
    }

    /**
     * Set the State of the document after processing the action
     * 
     * @param stateAfter
     *            The StateAfter
     */
    public void setStateAfter( State stateAfter )
    {
        _stateAfter = stateAfter;
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
    public String getResourceId( )
    {
        return Integer.toString( _nId );
    }

    /**
     *
     * @return the workflow associated
     */
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
    public void setListIdsLinkedAction( Collection<Integer> listIdsLinkedAction )
    {
        _listIdsLinkedAction = listIdsLinkedAction;
    }

    /**
     * @return the _listIdsLinkedAction
     */
    public Collection<Integer> getListIdsLinkedAction( )
    {
        return _listIdsLinkedAction;
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
}
