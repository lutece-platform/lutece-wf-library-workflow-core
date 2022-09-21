package fr.paris.lutece.plugins.workflowcore.service.action;

import java.util.List;

import fr.paris.lutece.plugins.workflowcore.business.action.Action;
import fr.paris.lutece.plugins.workflowcore.business.state.State;

public interface IActionStateService {
	
	/**
     * Creation of an instance of action
     * 
     * @param action
     *            The instance of action which contains the informations to store
     */
    void create( Action action );

    /**
     * Update of action which is specified in parameter
     * 
     * @param action
     *            The instance of action which contains the informations to update
     */
    void update( Action action );

    /**
     * Remove action which is specified in parameter
     * 
     * @param nIdAction
     *            The action id which contains the informations to remove
     */
    void remove( int nIdAction );
    
    // /////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Load the Action Object
     * 
     * @param nIdAction
     *            the action id
     * @return the Action Object
     */
    List<State> findByIdAction( int nIdAction );

}
