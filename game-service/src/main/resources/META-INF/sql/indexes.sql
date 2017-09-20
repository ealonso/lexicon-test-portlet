create index IX_9730DF08 on Game_Character (groupId);
create index IX_37FDE156 on Game_Character (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4D1AC558 on Game_Character (uuid_[$COLUMN_LENGTH:75$], groupId);