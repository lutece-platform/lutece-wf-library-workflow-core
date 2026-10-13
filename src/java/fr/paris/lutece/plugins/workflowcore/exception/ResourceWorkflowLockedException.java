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
package fr.paris.lutece.plugins.workflowcore.exception;

/**
 * Thrown when a workflow action cannot claim its resource: another request is processing an action on the same resource,
 * on this instance or another one, or the state of the resource has changed since the action was displayed
 */
public class ResourceWorkflowLockedException extends WorkflowRuntimeException
{
    private static final long serialVersionUID = -3530734581254707420L;

    private final int _nIdResource;
    private final String _strResourceType;
    private final int _nIdAction;

    /**
     * Constructor
     *
     * @param nIdResource
     *            the resource id
     * @param strResourceType
     *            the resource type
     * @param nIdAction
     *            the action id
     */
    public ResourceWorkflowLockedException( int nIdResource, String strResourceType, int nIdAction )
    {
        super( "The action " + nIdAction + " cannot be processed on the resource " + strResourceType + " " + nIdResource
                + ": another action is in progress on this resource or its state has changed", null );
        _nIdResource = nIdResource;
        _strResourceType = strResourceType;
        _nIdAction = nIdAction;
    }

    /**
     * @return the resource id
     */
    public int getIdResource( )
    {
        return _nIdResource;
    }

    /**
     * @return the resource type
     */
    public String getResourceType( )
    {
        return _strResourceType;
    }

    /**
     * @return the action id
     */
    public int getIdAction( )
    {
        return _nIdAction;
    }
}
