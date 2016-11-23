package dao.uow;

public class Entity {

	
	private EntityState state;
	IUnitOfWorkRepository repo;
	
	public Entity(IUnitOfWorkRepository repo) {
		super();
		this.repo = repo;
		this.state = EntityState.Unchanged;
	}
	Object entity;
	
	public <TEntity> void setEntity(TEntity entity){
		this.entity= entity;
	}
	
	public Object getEntity(){
		return  this.entity;
	}

	public EntityState getState() {
		return state;
	}

	public void setState(EntityState state) {
		this.state = state;
	}
	
	
	
	
}

