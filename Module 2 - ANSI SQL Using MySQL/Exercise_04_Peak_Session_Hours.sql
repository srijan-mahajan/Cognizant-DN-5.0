SELECT e.event_id,
       e.title,
       COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s
ON e.event_id = s.event_id
WHERE HOUR(s.start_time) BETWEEN 10 AND 11
GROUP BY e.event_id, e.title;