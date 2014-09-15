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
package com.github.mrstampy.pprspray.jasypt.receiver;

import org.jasypt.util.binary.BasicBinaryEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mrstampy.pprspray.core.receiver.MediaTransformer;

// TODO: Auto-generated Javadoc
/**
 * The Class JasyptMediaTransformer.
 */
public class JasyptMediaTransformer implements MediaTransformer {

	/** The Constant log. */
	public static final Logger log = LoggerFactory.getLogger(JasyptMediaTransformer.class);

	private BasicBinaryEncryptor encryptor;

	/**
	 * The Constructor.
	 *
	 * @param encryptor
	 *          the encryptor
	 */
	public JasyptMediaTransformer(BasicBinaryEncryptor encryptor) {
		this.encryptor = encryptor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.github.mrstampy.pprspray.core.receiver.MediaTransformer#transform(byte
	 * [], int)
	 */
	@Override
	public byte[] transform(byte[] data, int mediaHash) {
		try {
			return encryptor.decrypt(data);
		} catch (Exception e) {
			log.trace("Cannot decrypt", e);
		}

		return null;
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
