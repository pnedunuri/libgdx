/*
 *  This file is part of Libgdx by Mario Zechner (badlogicgames@gmail.com)
 *
 *  Libgdx is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Libgdx is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with libgdx.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.badlogic.gdx.backends.applet;

import java.applet.Applet;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;

/**
 * An implemenation of the {@link Application} interface based on Jogl for Windows, Linux and Mac. Instantiate
 * this class with apropriate parameters and then register {@link ApplicationListener}, {@link RenderListener} or {@link InputListener}
 * instances.
 * 
 * @author mzechner
 *
 */
public class AppletApplication implements Application
{
	/** the graphics instance **/
	private AppletGraphics graphics;
	
	/** the input instance **/
	private AppletInput input;
	
	/** the audio instance **/
	private AppletAudio audio;
	
	/** the DestroyListener **/
	ApplicationListener listener;
	
	/**
	 * Initializes a new {@link AppletApplication}. If useGL20IfAvailable is set the
	 * AppletApplication will try to create an OpenGL 2.0 context
	 * which can then be used via {@link AppletApplication.getGraphics().getGL20()}. The
	 * {@link GL10} and {@link GL11} interfaces should not be used when
	 * OpenGL 2.0 is enabled. To query whether enabling OpenGL 2.0 was
	 * successful use the {@link AppletApplication.getGraphics().isGL20Available()}
	 * method. 
	 * 
	 * @param useGL20IfAvailable wheter to use OpenGL 2.0 if it is available or not
	 * @param allowFixedPoint not allowing fixed point will reduce memory consumption considerably
	 */
	public AppletApplication( Applet applet, boolean useGL20IfAvailable, boolean allowFixedPoint )
	{
		graphics = new AppletGraphics( this, applet, useGL20IfAvailable, allowFixedPoint );
		input = new AppletInput( graphics.graphicPanel );
		audio = new AppletAudio( );
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Audio getAudio() 
	{	
		return audio;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Files getFiles() 
	{	
		return new AppletFiles( );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Graphics getGraphics() 
	{	
		return graphics;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Input getInput() 
	{	
		return input;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setApplicationListener(ApplicationListener listener) 
	{	
		this.listener = listener;
	}

	@Override
	public void log(String tag, String message) 
	{	
		System.out.println( tag + ": " + message );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApplicationType getType() 
	{	
		return ApplicationType.Applet;
	}

}
