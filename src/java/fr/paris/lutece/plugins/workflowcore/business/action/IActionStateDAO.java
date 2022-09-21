package fr.paris.lutece.plugins.workflowcore.business.action;

import java.util.List;

public interface IActionStateDAO {

	/**
     * Insert a new record in the table.
     *
     * @param action
     *            instance of the Action object to insert
     */
    void insert( int nIdAction, int nIdState );

    /**
     * update record in the table.
     *
     * @param action
     *            instance of the Action object to update
     */
    void store( int nNewIdAction, int nNewIdState, int nOldIdAction, int nOldIdState );

    /**
     * Load the action Object
     * 
     * @param nIdAction
     *            the state id
     * @return the Action Object
     */
    List<Integer> load( int nIdAction );
    
    /**
     * Delete the action Object
     * 
     * @param nIdAction
     *            the action id
     */
     void delete( int nIdAction );
}
