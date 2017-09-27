/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.game.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.game.exception.NoSuchCharacterException;
import com.liferay.game.model.Character;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the character service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.game.service.persistence.impl.CharacterPersistenceImpl
 * @see CharacterUtil
 * @generated
 */
@ProviderType
public interface CharacterPersistence extends BasePersistence<Character> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CharacterUtil} to access the character persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the characters where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching characters
	*/
	public java.util.List<Character> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the characters where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @return the range of matching characters
	*/
	public java.util.List<Character> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the characters where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching characters
	*/
	public java.util.List<Character> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns an ordered range of all the characters where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching characters
	*/
	public java.util.List<Character> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first character in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the first character in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the last character in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the last character in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the characters before and after the current character in the ordered set where uuid = &#63;.
	*
	* @param characterId the primary key of the current character
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next character
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public Character[] findByUuid_PrevAndNext(long characterId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Removes all the characters where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of characters where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching characters
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the character where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchCharacterException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchCharacterException;

	/**
	* Returns the character where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the character where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the character where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the character that was removed
	*/
	public Character removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchCharacterException;

	/**
	* Returns the number of characters where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching characters
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the characters where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching characters
	*/
	public java.util.List<Character> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the characters where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @return the range of matching characters
	*/
	public java.util.List<Character> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the characters where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching characters
	*/
	public java.util.List<Character> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns an ordered range of all the characters where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching characters
	*/
	public java.util.List<Character> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first character in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the first character in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the last character in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the last character in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the characters before and after the current character in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param characterId the primary key of the current character
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next character
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public Character[] findByUuid_C_PrevAndNext(long characterId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Removes all the characters where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of characters where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching characters
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the characters where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching characters
	*/
	public java.util.List<Character> findByGroupId(long groupId);

	/**
	* Returns a range of all the characters where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @return the range of matching characters
	*/
	public java.util.List<Character> findByGroupId(long groupId, int start,
		int end);

	/**
	* Returns an ordered range of all the characters where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching characters
	*/
	public java.util.List<Character> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns an ordered range of all the characters where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching characters
	*/
	public java.util.List<Character> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first character in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the first character in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the last character in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the last character in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the characters before and after the current character in the ordered set where groupId = &#63;.
	*
	* @param characterId the primary key of the current character
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next character
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public Character[] findByGroupId_PrevAndNext(long characterId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Removes all the characters where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of characters where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching characters
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the characters where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the matching characters
	*/
	public java.util.List<Character> findByG_N(long groupId,
		java.lang.String name);

	/**
	* Returns a range of all the characters where groupId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @return the range of matching characters
	*/
	public java.util.List<Character> findByG_N(long groupId,
		java.lang.String name, int start, int end);

	/**
	* Returns an ordered range of all the characters where groupId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching characters
	*/
	public java.util.List<Character> findByG_N(long groupId,
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns an ordered range of all the characters where groupId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching characters
	*/
	public java.util.List<Character> findByG_N(long groupId,
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first character in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByG_N_First(long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the first character in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByG_N_First(long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the last character in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character
	* @throws NoSuchCharacterException if a matching character could not be found
	*/
	public Character findByG_N_Last(long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Returns the last character in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching character, or <code>null</code> if a matching character could not be found
	*/
	public Character fetchByG_N_Last(long groupId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns the characters before and after the current character in the ordered set where groupId = &#63; and name = &#63;.
	*
	* @param characterId the primary key of the current character
	* @param groupId the group ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next character
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public Character[] findByG_N_PrevAndNext(long characterId, long groupId,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator)
		throws NoSuchCharacterException;

	/**
	* Removes all the characters where groupId = &#63; and name = &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	*/
	public void removeByG_N(long groupId, java.lang.String name);

	/**
	* Returns the number of characters where groupId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @return the number of matching characters
	*/
	public int countByG_N(long groupId, java.lang.String name);

	/**
	* Caches the character in the entity cache if it is enabled.
	*
	* @param character the character
	*/
	public void cacheResult(Character character);

	/**
	* Caches the characters in the entity cache if it is enabled.
	*
	* @param characters the characters
	*/
	public void cacheResult(java.util.List<Character> characters);

	/**
	* Creates a new character with the primary key. Does not add the character to the database.
	*
	* @param characterId the primary key for the new character
	* @return the new character
	*/
	public Character create(long characterId);

	/**
	* Removes the character with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param characterId the primary key of the character
	* @return the character that was removed
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public Character remove(long characterId) throws NoSuchCharacterException;

	public Character updateImpl(Character character);

	/**
	* Returns the character with the primary key or throws a {@link NoSuchCharacterException} if it could not be found.
	*
	* @param characterId the primary key of the character
	* @return the character
	* @throws NoSuchCharacterException if a character with the primary key could not be found
	*/
	public Character findByPrimaryKey(long characterId)
		throws NoSuchCharacterException;

	/**
	* Returns the character with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param characterId the primary key of the character
	* @return the character, or <code>null</code> if a character with the primary key could not be found
	*/
	public Character fetchByPrimaryKey(long characterId);

	@Override
	public java.util.Map<java.io.Serializable, Character> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the characters.
	*
	* @return the characters
	*/
	public java.util.List<Character> findAll();

	/**
	* Returns a range of all the characters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @return the range of characters
	*/
	public java.util.List<Character> findAll(int start, int end);

	/**
	* Returns an ordered range of all the characters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of characters
	*/
	public java.util.List<Character> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator);

	/**
	* Returns an ordered range of all the characters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CharacterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of characters
	* @param end the upper bound of the range of characters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of characters
	*/
	public java.util.List<Character> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Character> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the characters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of characters.
	*
	* @return the number of characters
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}