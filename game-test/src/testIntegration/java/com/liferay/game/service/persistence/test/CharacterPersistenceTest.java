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

package com.liferay.game.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.game.exception.NoSuchCharacterException;
import com.liferay.game.model.Character;
import com.liferay.game.service.CharacterLocalServiceUtil;
import com.liferay.game.service.persistence.CharacterPersistence;
import com.liferay.game.service.persistence.CharacterUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CharacterPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"com.liferay.game.service"));

	@Before
	public void setUp() {
		_persistence = CharacterUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Character> iterator = _characters.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Character character = _persistence.create(pk);

		Assert.assertNotNull(character);

		Assert.assertEquals(character.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Character newCharacter = addCharacter();

		_persistence.remove(newCharacter);

		Character existingCharacter = _persistence.fetchByPrimaryKey(newCharacter.getPrimaryKey());

		Assert.assertNull(existingCharacter);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCharacter();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Character newCharacter = _persistence.create(pk);

		newCharacter.setUuid(RandomTestUtil.randomString());

		newCharacter.setGroupId(RandomTestUtil.nextLong());

		newCharacter.setCompanyId(RandomTestUtil.nextLong());

		newCharacter.setUserId(RandomTestUtil.nextLong());

		newCharacter.setUserName(RandomTestUtil.randomString());

		newCharacter.setCreateDate(RandomTestUtil.nextDate());

		newCharacter.setModifiedDate(RandomTestUtil.nextDate());

		newCharacter.setName(RandomTestUtil.randomString());

		newCharacter.setUrl(RandomTestUtil.randomString());

		newCharacter.setStatus(RandomTestUtil.randomString());

		_characters.add(_persistence.update(newCharacter));

		Character existingCharacter = _persistence.findByPrimaryKey(newCharacter.getPrimaryKey());

		Assert.assertEquals(existingCharacter.getUuid(), newCharacter.getUuid());
		Assert.assertEquals(existingCharacter.getCharacterId(),
			newCharacter.getCharacterId());
		Assert.assertEquals(existingCharacter.getGroupId(),
			newCharacter.getGroupId());
		Assert.assertEquals(existingCharacter.getCompanyId(),
			newCharacter.getCompanyId());
		Assert.assertEquals(existingCharacter.getUserId(),
			newCharacter.getUserId());
		Assert.assertEquals(existingCharacter.getUserName(),
			newCharacter.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingCharacter.getCreateDate()),
			Time.getShortTimestamp(newCharacter.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingCharacter.getModifiedDate()),
			Time.getShortTimestamp(newCharacter.getModifiedDate()));
		Assert.assertEquals(existingCharacter.getName(), newCharacter.getName());
		Assert.assertEquals(existingCharacter.getUrl(), newCharacter.getUrl());
		Assert.assertEquals(existingCharacter.getStatus(),
			newCharacter.getStatus());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUUID_G(StringPool.NULL, 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testCountByG_N() throws Exception {
		_persistence.countByG_N(RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByG_N(0L, StringPool.NULL);

		_persistence.countByG_N(0L, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Character newCharacter = addCharacter();

		Character existingCharacter = _persistence.findByPrimaryKey(newCharacter.getPrimaryKey());

		Assert.assertEquals(existingCharacter, newCharacter);
	}

	@Test(expected = NoSuchCharacterException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Character> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Game_Character", "uuid",
			true, "characterId", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "name", true, "url", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Character newCharacter = addCharacter();

		Character existingCharacter = _persistence.fetchByPrimaryKey(newCharacter.getPrimaryKey());

		Assert.assertEquals(existingCharacter, newCharacter);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Character missingCharacter = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCharacter);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Character newCharacter1 = addCharacter();
		Character newCharacter2 = addCharacter();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCharacter1.getPrimaryKey());
		primaryKeys.add(newCharacter2.getPrimaryKey());

		Map<Serializable, Character> characters = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, characters.size());
		Assert.assertEquals(newCharacter1,
			characters.get(newCharacter1.getPrimaryKey()));
		Assert.assertEquals(newCharacter2,
			characters.get(newCharacter2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Character> characters = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(characters.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Character newCharacter = addCharacter();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCharacter.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Character> characters = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, characters.size());
		Assert.assertEquals(newCharacter,
			characters.get(newCharacter.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Character> characters = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(characters.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Character newCharacter = addCharacter();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCharacter.getPrimaryKey());

		Map<Serializable, Character> characters = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, characters.size());
		Assert.assertEquals(newCharacter,
			characters.get(newCharacter.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = CharacterLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Character>() {
				@Override
				public void performAction(Character character) {
					Assert.assertNotNull(character);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Character newCharacter = addCharacter();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Character.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("characterId",
				newCharacter.getCharacterId()));

		List<Character> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Character existingCharacter = result.get(0);

		Assert.assertEquals(existingCharacter, newCharacter);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Character.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("characterId",
				RandomTestUtil.nextLong()));

		List<Character> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Character newCharacter = addCharacter();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Character.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("characterId"));

		Object newCharacterId = newCharacter.getCharacterId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("characterId",
				new Object[] { newCharacterId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCharacterId = result.get(0);

		Assert.assertEquals(existingCharacterId, newCharacterId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Character.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("characterId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("characterId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Character newCharacter = addCharacter();

		_persistence.clearCache();

		Character existingCharacter = _persistence.findByPrimaryKey(newCharacter.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingCharacter.getUuid(),
				ReflectionTestUtil.invoke(existingCharacter, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingCharacter.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingCharacter,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected Character addCharacter() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Character character = _persistence.create(pk);

		character.setUuid(RandomTestUtil.randomString());

		character.setGroupId(RandomTestUtil.nextLong());

		character.setCompanyId(RandomTestUtil.nextLong());

		character.setUserId(RandomTestUtil.nextLong());

		character.setUserName(RandomTestUtil.randomString());

		character.setCreateDate(RandomTestUtil.nextDate());

		character.setModifiedDate(RandomTestUtil.nextDate());

		character.setName(RandomTestUtil.randomString());

		character.setUrl(RandomTestUtil.randomString());

		character.setStatus(RandomTestUtil.randomString());

		_characters.add(_persistence.update(character));

		return character;
	}

	private List<Character> _characters = new ArrayList<Character>();
	private CharacterPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}