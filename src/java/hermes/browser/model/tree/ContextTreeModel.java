/* 
 * Copyright 2003,2004 Colin Crist
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package hermes.browser.model.tree;

import hermes.JNDIContextFactory;

import javax.swing.tree.DefaultTreeModel;

/**
 * @author colincrist@hermesjms.com last changed by: $Author: colincrist $
 * @version $Id: ContextTreeModel.java,v 1.2 2005/05/01 11:23:53 colincrist Exp $
 */
public class ContextTreeModel extends DefaultTreeModel
{
    private JNDIContextFactory contextFactory ; 
    /**
     * @param root
     */
    public ContextTreeModel(JNDIContextFactory contextFactory, ContextTreeNode root)
    {
        super(root);
        
        this.contextFactory = contextFactory ;
    }
    
    public JNDIContextFactory getContextFactory() 
    {
        return contextFactory ;
    }
}
