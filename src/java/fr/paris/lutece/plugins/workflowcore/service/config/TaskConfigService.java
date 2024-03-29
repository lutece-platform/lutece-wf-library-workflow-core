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
package fr.paris.lutece.plugins.workflowcore.service.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.paris.lutece.plugins.workflowcore.business.config.ITaskConfig;
import fr.paris.lutece.plugins.workflowcore.business.config.ITaskConfigDAO;


/**
 *
 * TaskConfigService
 *
 */
public class TaskConfigService implements ITaskConfigService
{
    private static Logger _logger = LogManager.getLogger( "lutece.workflow" );
    private ITaskConfigDAO<ITaskConfig> _taskConfigDAO;

    /**
     * Set the task config dao
     * 
     * @param taskConfigDAO
     *            the task config DAO
     */
    public void setTaskConfigDAO( ITaskConfigDAO<ITaskConfig> taskConfigDAO )
    {
        _taskConfigDAO = taskConfigDAO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create( ITaskConfig config )
    {
        if ( config != null )
        {
            _taskConfigDAO.insert( config );
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update( ITaskConfig config )
    {
        if ( config != null )
        {
            _taskConfigDAO.store( config );
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove( int nIdTask )
    {
        _taskConfigDAO.delete( nIdTask );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T findByPrimaryKey( int nIdTask )
    {
        return getConfigBean( _taskConfigDAO.load( nIdTask ) );
    }

    /**
     * Get the config bean
     * 
     * @param <T>
     *            The class of the bean
     * @param config
     *            the config
     * @return the config bean
     */
    public static <T> T getConfigBean( ITaskConfig config )
    {
        if ( config != null )
        {
            try
            {
                return (T) config;
            }
            catch( Exception e )
            {
                _logger.error( e.getMessage( ), e );
            }
        }

        return null;
    }

    /**
     * Get the DAO
     * 
     * @return the DAO
     */
    protected ITaskConfigDAO<ITaskConfig> getDAO( )
    {
        return _taskConfigDAO;
    }
}
