package fr.paris.lutece.plugins.workflowcore.service.action;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import fr.paris.lutece.plugins.workflowcore.business.action.Action;
import fr.paris.lutece.plugins.workflowcore.business.action.IActionStateDAO;
import fr.paris.lutece.plugins.workflowcore.business.state.IStateDAO;
import fr.paris.lutece.plugins.workflowcore.business.state.State;

public class ActionStateService implements IActionStateService {
	
	public static final String BEAN_SERVICE = "workflow.actionStateService";
	@Inject
	private IActionStateDAO _actionStateDAO;
	@Inject
    private IStateDAO _stateDAO;
	
	/**
     * {@inheritDoc}
     */
    @Override
    public void create( Action action )
    {
    	for ( State state : action.getListStateBefore( ) )
        {
    		_actionStateDAO.insert( action.getId( ), state.getId( ) );
        }
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public void update( Action action ) {
		_actionStateDAO.delete( action.getId( ) );
		create( action );		
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public void remove(int nIdAction) {
		_actionStateDAO.delete( nIdAction );
		
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public List<State> findByIdAction(int nIdAction) {
		List<State> listStateBefore = new ArrayList<>( );
		for (Integer nState : _actionStateDAO.load( nIdAction ) )
		{
			State stateBefore = _stateDAO.load( nState.intValue( ) );
			if ( stateBefore != null )
			{
				listStateBefore.add( stateBefore );
			}
		}
		return listStateBefore;
	}
	
	

}
