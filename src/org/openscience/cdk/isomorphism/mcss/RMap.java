/*
 *  $RCSfile$
 *  $Author$
 *  $Date$
 *  $Revision$
 *
 *  Copyright (C) 1997-2002  The Chemistry Development Kit (CDK) project
 *
 *  This code has been kindly provided by Stephane Werner
 *  and Thierry Hanser from IXELIS mail@ixelis.net
 *
 *  IXELIS sarl - Semantic Information Systems
 *  17 rue des C�dres 67200 Strasbourg, France
 *  Tel/Fax : +33(0)3 88 27 81 39 Email: mail@ixelis.net
 *
 *  CDK Contact: cdk-devel@lists.sf.net
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2.1
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 */
package org.openscience.cdk.isomorphism.mcss;

/**
 *  An RMap implements the association between an edge (bond) in G1 and an edge
 *  (bond) in G2, G1 and G2 being the compared graphs in a RGraph context.
 *
 *@author     Stephane Werner from IXELIS mail@ixelis.net
 *@created    24 juillet 2002
 */
public class RMap
{
	int id1 = 0;
	int id2 = 0;


	/**
	 *  Constructor for the RMap
	 *
	 *@param  id1  number of the edge (bond) in the graphe 1
	 *@param  id2  number of the edge (bond) in the graphe 2
	 */
	public RMap(int id1, int id2)
	{
		this.id1 = id1;
		this.id2 = id2;
	}


	/**
	 *  Sets the id1 attribute of the RMap object
	 *
	 *@param  id1  The new id1 value
	 */
	public void setId1(int id1)
	{
		this.id1 = id1;
	}


	/**
	 *  Sets the id2 attribute of the RMap object
	 *
	 *@param  id2  The new id2 value
	 */
	public void setId2(int id2)
	{
		this.id2 = id2;
	}


	/**
	 *  Gets the id1 attribute of the RMap object
	 *
	 *@return    The id1 value
	 */
	public int getId1()
	{
		return id1;
	}


	/**
	 *  Gets the id2 attribute of the RMap object
	 *
	 *@return    The id2 value
	 */
	public int getId2()
	{
		return id2;
	}

}

