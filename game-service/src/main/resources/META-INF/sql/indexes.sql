create index IX_C99C8C7 on Game_Character (groupId, name[$COLUMN_LENGTH:75$]);
create index IX_65B83221 on Game_Character (name[$COLUMN_LENGTH:75$]);
create index IX_37FDE156 on Game_Character (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4D1AC558 on Game_Character (uuid_[$COLUMN_LENGTH:75$], groupId);