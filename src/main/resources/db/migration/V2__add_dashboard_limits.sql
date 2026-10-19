
-- 1. Add the dashboard limit.
ALTER TABLE public.plan
    ADD COLUMN max_dashboards INTEGER;

-- 2. Backfill existing rows.
UPDATE public.plan
SET max_dashboards = 15
WHERE max_dashboards IS NULL;

-- 3. Enforce required values and defaults.
ALTER TABLE public.plan
    ALTER COLUMN max_dashboards SET NOT NULL,
ALTER COLUMN max_tasks_per_dashboard SET DEFAULT 50,
    ALTER COLUMN max_tasks_per_dashboard SET NOT NULL,
    ALTER COLUMN active SET DEFAULT TRUE;

-- 4. Prevent negative dashboard limits.
ALTER TABLE public.plan
    ADD CONSTRAINT chk_plan_max_dashboards
        CHECK (max_dashboards >= 0);

-- 5. Make plan names unique.
CREATE UNIQUE INDEX uq_plan_plan_name
    ON public.plan (plan_name);

-- 6. Insert the initial plan catalogue.
INSERT INTO public.plan (
    plan_name,
    max_dashboards,
    max_tasks_per_dashboard,
    price,
    active
)
VALUES
    ('FREE', 15, 50, 0.00, TRUE),
    ('PLUS', 30, 75, 49.00, TRUE),
    ('PRO', 60, 100, 99.00, TRUE)
    ON CONFLICT (plan_name) DO NOTHING;
