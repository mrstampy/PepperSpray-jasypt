/*
 * PepperSpray-jasypt - demonstration encryption for the PepperSpray-core framework
 *
 * Copyright (C) 2014 Burton Alexander
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 * 
 */
package com.github.mrstampy.pprspray.jasypt.streamer.webcam;

import java.awt.image.BufferedImage;

import org.jasypt.util.binary.BasicBinaryEncryptor;

import com.github.mrstampy.pprspray.core.streamer.webcam.DefaultWebcamImageTransformer;

// TODO: Auto-generated Javadoc
/**
 * The Class JasyptWebcamImageTransformer.
 */
public class JasyptWebcamImageTransformer extends DefaultWebcamImageTransformer {

	private BasicBinaryEncryptor encryptor;

	/**
	 * The Constructor.
	 *
	 * @param encryptor
	 *          the encryptor
	 */
	public JasyptWebcamImageTransformer(BasicBinaryEncryptor encryptor) {
		this.encryptor = encryptor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.github.mrstampy.pprspray.core.streamer.webcam.DefaultWebcamImageTransformer
	 * #transform(java.awt.image.BufferedImage)
	 */
	@Override
	public byte[] transform(BufferedImage image) {
		byte[] transformed = super.transform(image);

		return encryptor.encrypt(transformed);
	}

	/**
	 * Gets the encryptor.
	 *
	 * @return the encryptor
	 */
	public BasicBinaryEncryptor getEncryptor() {
		return encryptor;
	}

}
