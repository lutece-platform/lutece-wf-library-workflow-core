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
package fr.paris.lutece.plugins.workflowcore.service.provider;

/**
 * <p>
 * This class represents a marker for passing values to other tasks. In the Notify task configuration, some fields can contains markers which are replaced by
 * the actual value of the resource when the {@link fr.paris.lutece.plugins.grubusiness.business.notification.Notification} is send.
 * </p>
 * <p>
 * This class has two goals:
 * <ul>
 * <li>To give the description of the marker in the task configuration page</li>
 * <li>To give the actual value of the resource at sending time</li>
 * </ul>
 * </p>
 *
 */
public class InfoMarker
{
    private final String _strMarker;

    private String _strDescription;

    private Object _strValue;

    /**
     * Constructor
     *
     * @param strMarker
     *            the marker
     */
    public InfoMarker( String strMarker )
    {
        _strMarker = strMarker;
    }

    /**
     * Gives the marker
     *
     * @return the marker
     */
    public String getMarker( )
    {
        return _strMarker;
    }

    /**
     * <p>
     * Gives the description of the marker.
     * </p>
     * <p>
     * Used in the task configuration page
     * </p>
     *
     * @return the description
     */
    public String getDescription( )
    {
        return _strDescription;
    }

    /**
     * Sets the description of the marker
     *
     * @param strDescription
     *            the description to set
     */
    public void setDescription( String strDescription )
    {
        _strDescription = strDescription;
    }

    /**
     * <p>
     * Gives the value of the marker. The value is the actual value of the resource.
     * </p>
     * <p>
     * Used when the notification is sent
     * </p>
     *
     * @return the value
     */
    public Object getValue( )
    {
        return _strValue;
    }

    /**
     * Sets the value of the marker
     *
     * @param strValue
     *            the value to set
     */
    public void setValue( Object strValue )
    {
        _strValue = strValue;
    }

}
