package hermes.browser.model.tree;

import hermes.Hermes;
import hermes.browser.IconCache;
import hermes.config.JMSSessionGroupConfig;

import org.apache.log4j.Logger;

public class FolderTreeNode extends AbstractTreeNode {

	private static final long serialVersionUID = 2826749580919054161L;
	private static final Logger log = Logger.getLogger(FolderTreeNode.class);
	private JMSSessionGroupConfig jmsSessionGroupConfig;
	
	public FolderTreeNode(String id, Hermes hermes, JMSSessionGroupConfig jmsSessionGroupConfig) {
		super(id, hermes);
		//super(id, jmsSessionGroupConfig);

		this.jmsSessionGroupConfig = jmsSessionGroupConfig;
		
		setOpenIcon(IconCache.getIcon("hermes.tree.folder.opened")) ;
		setIcon(IconCache.getIcon("hermes.tree.folder.closed")) ;
	}

	public JMSSessionGroupConfig getJmsSessionGroupConfig() {
		return jmsSessionGroupConfig;
	}

	public void setJmsSessionGroupConfig(JMSSessionGroupConfig jmsSessionGroupConfig) {
		this.jmsSessionGroupConfig = jmsSessionGroupConfig;
	}

	public Hermes getHermes() {
		return (Hermes) getBean();
	}
}
